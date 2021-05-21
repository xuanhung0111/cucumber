//package com.zinio.zenith.util;
//
//import com.zinio.zenith.configs.TestDatabaseConfig;
//import com.zinio.zenith.cucumber.hook.*;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Component;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
///**
// * Created by ducnguyen on 9/17/16.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestDatabaseConfig.class})
////@TestPropertySource(locations = "classpath:${env}-application.properties")
//@TestPropertySource(locations = "src/main/resources/application.properties")
//@Component
//public class TestDataGenerator implements ApplicationContextAware {
//    private static final Logger LOGGER = LoggerFactory.getLogger(TestDataGenerator.class);
//    private ApplicationContext context;
//
//    public void setApplicationContext(ApplicationContext context) throws BeansException {
//        this.context = context;
//    }
//
//    @Test
////    @Ignore
//    public void generateTestData() throws SQLException, IOException {
//        this.generate();
//    }
//
//    public void generate() throws SQLException, IOException {
//        LOGGER.info("Populate test data ......");
//        new BuildIdentityData().populate(this.context, TestDataSize.MAX_USERS);
//        LOGGER.info("Populate test data completed");
//
//    }
//}
