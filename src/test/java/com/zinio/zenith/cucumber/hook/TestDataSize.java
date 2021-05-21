package com.zinio.zenith.cucumber.hook;

/**
 * Created by ducnguyen on 9/16/16.
 */
public interface TestDataSize {
    long MAX_USERS = 100;
    long MAX_PUBLISHERS = 10;
    long MAX_PUBLICATION = 100;
    long MAX_ISSUES = 1000;
    long MAX_ENTITLEMENTS = 10000;
    //    private static final long MAX_MOBILES = 200;
    long MAX_PROJECTS = 800;
    long MAX_SINGLE_ISSUE_PRICES = 10000;
    long MAX_NEWSSTAND = 100;
    long MAX_CATALOGS = 100;
    long MAX_APPLICATION = 100;
    long MAX_DEVICES = 1000;
    long MAX_PRODUCTS = 1000;
    long MAX_ACTIVE_PRICES = 1000;
    long MAX_PAYMENT_HANDLERS = 4;
    long MAX_USER_PAYMENT_PROFILE = MAX_PAYMENT_HANDLERS * MAX_USERS; // A user has maximum 2 payment profiles
    //    long MAX_CATALOG_PUBLICATION_RELATIONS = MAX_CATALOGS * MAX_PUBLICATION;
    long MAX_CATALOG_PUBLICATION_RELATIONS = 5 * MAX_CATALOGS;

}
