package com.zinio.zenith;

import com.zinio.zenith.configs.TestDatabaseConfig;
import com.zinio.zenith.models.dao.DaoFactory;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ducnguyen on 9/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfig.class})
//@TestPropertySource(locations = "classpath:${env}-application.properties")
@TestPropertySource(locations = "src/main/resources/application.properties")
@Ignore
public class AbstractSpringTest {
    @Autowired
    protected Environment env;
    @Autowired
    protected DaoFactory daoFactory;

    protected String getBaseUrl() {
        return env.getProperty("zenith.base.url");
    }

    protected DaoFactory getDaoFactory() {
        return daoFactory;
    }

    protected Environment getEnv() {
        return env;
    }
}
