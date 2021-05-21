//package com.zinio.zenith.cucumber.hook;
//
//import com.zinio.zenith.util.TestDataGenerator;
//import cucumber.api.java.Before;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.jdbc.datasource.init.ScriptUtils;
//import org.springframework.jdbc.datasource.init.UncategorizedScriptException;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.TransactionDefinition;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.support.DefaultTransactionDefinition;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//import javax.transaction.SystemException;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.stream.LongStream;
//
///**
// * Created by ducnguyen on 9/11/16.
// */
//@Component
//public class CucumberHooks implements ApplicationContextAware {
//    private static final Logger LOGGER = LoggerFactory.getLogger(CucumberHooks.class);
//    private static ApplicationContext context;
//
//    public void setApplicationContext(ApplicationContext context) throws BeansException {
//        this.context = context;
//    }
//
//    public static ApplicationContext getApplicationContext() {
//        return context;
//    }
//
//    private static boolean hasBeenRun = false;
//
//    @Before(order = 2)
//    public synchronized void setUp() throws SQLException, SystemException, IOException {
//        Environment env = context.getBean(Environment.class);
//        if (hasBeenRun
//                || Boolean.parseBoolean(env.getProperty("skipGenerateTestData", "false"))) {
//            LOGGER.info("Skip generating test data ......");
//            return;
//        }
//        hasBeenRun = true;
//        LOGGER.info("Populate test data ..........");
//        TestDataGenerator testDataGenerator = context.getBean(TestDataGenerator.class);
//        testDataGenerator.generate();
//        LOGGER.info("Populate test data completed");
//    }
//
//
//}
