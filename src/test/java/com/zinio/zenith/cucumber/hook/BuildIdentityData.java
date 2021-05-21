package com.zinio.zenith.cucumber.hook;

import com.zinio.zenith.cucumber.hook.idgen.SqlDateGenerator;
import com.zinio.zenith.cucumber.hook.idgen.UserIdGenerator;
import com.zinio.zenith.models.dao.DaoFactory;
import com.zinio.zenith.models.dao.EntityDao;
import com.zinio.zenith.models.identity.UsersEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.stream.LongStream;

/**
 * Created by ducnguyen on 9/14/16.
 */
public class BuildIdentityData extends AbstractBuildData {
    private static final Logger LOGGER = LoggerFactory.getLogger(BuildIdentityData.class);
//    private static final Short UNKNOWN = Short.valueOf("0");
//    private static final Short STATIC = Short.valueOf("1");
//    private static final Short AYCE = Short.valueOf("2");

    private final UserIdGenerator userIdGenerator;
    private final SqlDateGenerator sqlDateGenerator;

    public BuildIdentityData() {
        this(
                new UserIdGenerator(),
                new SqlDateGenerator()
        );
    }

    public BuildIdentityData(
            @NotNull UserIdGenerator userIdGenerator,
            @NotNull SqlDateGenerator sqlDateGenerator
    ) {
        this.userIdGenerator = userIdGenerator;
        this.sqlDateGenerator = sqlDateGenerator;
    }

    protected void generate(@NotNull ApplicationContext context, long amount) throws SQLException {
        DataSource dataSource = context.getBean(DataSource.class);
        ScriptUtils.executeSqlScript(
                dataSource.getConnection(),
                new ClassPathResource("/db-scripts/identity/clear_data.txt")
        );
        DaoFactory daoFactory = context.getBean(DaoFactory.class);
        EntityManager entityManager = daoFactory.getEntityManager();
        PlatformTransactionManager platformTransactionManager = context.getBean(PlatformTransactionManager.class);
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        try {
            EntityDao<UsersEntity> publishersDao = daoFactory.create(UsersEntity.class);
            LongStream
                    .range(0, Math.min(amount, this.userIdGenerator.getTotal()))
                    .forEach(i ->
                            saveEntity(entityManager, publishersDao, this.createUser(i))
                    );
//            PublicationsDao publicationsDao = context.getBean(PublicationsDao.class);
//            LongStream.range(1, MAX_PUBLICATION + 1).forEach(i ->
//                    saveEntity(entityManager, publicationsDao, BuildEntitlementData.createPublication(i, MAX_PUBLISHERS, MAX_USERS))
//            );
//            IssuesDao issuesDao = context.getBean(IssuesDao.class);
//            LongStream
//                    .range(1, MAX_ISSUES + 1)
//                    .forEach(i ->
//                            saveEntity(entityManager, issuesDao, BuildEntitlementData.createIssue(i, MAX_PUBLICATION, MAX_USERS, LEGACY_USERS_RATE, LEGACY_ISSUE_RATE))
//                    );
            platformTransactionManager.commit(transactionStatus);
        } catch (Exception e) {
            platformTransactionManager.rollback(transactionStatus);
            throw e;
        }

    }


    @Override
    protected Resource getSqlResource() {
        return new ClassPathResource("/db-scripts/entitlement/insert_order.txt");
    }

    private UsersEntity createUser(long id) {
        UsersEntity user = new UsersEntity();
        user.setId(this.userIdGenerator.genId(id));
        user.setEmail(String.format("user.mail.%d@tmpmail.com", this.userIdGenerator.genId(id)));
        user.setEncryptionMode((short) 1);
        user.setStatus((short) 1);
        Timestamp time = this.sqlDateGenerator.getDate(id);
        user.setCreatedAt(time);
        user.setModifiedAt(time);
        return user;
    }
}
