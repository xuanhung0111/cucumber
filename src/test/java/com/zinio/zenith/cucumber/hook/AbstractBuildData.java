package com.zinio.zenith.cucumber.hook;

import com.zinio.zenith.models.dao.EntityDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.jdbc.datasource.init.UncategorizedScriptException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 * Created by ducnguyen on 9/14/16.
 */
public abstract class AbstractBuildData {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractBuildData.class);

    public final void populate(@NotNull ApplicationContext context, long amount) throws IOException, SQLException {
        Environment env = context.getBean(Environment.class);
        DataSource dataSource = context.getBean(DataSource.class);
        if (Boolean.parseBoolean(env.getProperty("useCodeGenerator"))) {
            generate(context, amount);
        } else {
            useSQLDumpFile(dataSource, getSqlResource());
        }
    }

    protected <T> void saveEntity(EntityManager entityManager, EntityDao<T> entityDao, T entity) {
        try {
            entityDao.create(entity);
            entityManager.flush();
            entityManager.clear();
        } catch (PersistenceException e) {
            LOGGER.error("Cannot create entity:\n" + entity);
            throw e;
        }

    }

    protected abstract void generate(@NotNull ApplicationContext context, long amount) throws SQLException;

    protected abstract Resource getSqlResource();

    private void useSQLDumpFile(@NotNull DataSource dataSource, @NotNull Resource sqlResource) throws IOException {
        LOGGER.info("Using database dump files......");
//        ClassPathResource classPathResource = new ClassPathResource("/db-scripts/catalog/insert_order.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sqlResource.getInputStream()));
        bufferedReader
                .lines()
                .forEach(line -> {
                    try {
                        ScriptUtils.executeSqlScript(
                                dataSource.getConnection(),
                                new ClassPathResource(line)
                        );
                    } catch (UncategorizedScriptException e) {
                        LOGGER.warn(e.getMessage());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                });

    }

}
