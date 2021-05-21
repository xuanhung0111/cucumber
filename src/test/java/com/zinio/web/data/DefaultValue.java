package com.zinio.web.data;

public class DefaultValue {

    public enum PLACEHOLDER {
        country("Choose Country"),
        gender("Choose Gender"),
        email("Email"),
        password("Password"),
        firstName("First name"),
        lastName("Last name"),
        project("Choose Project"),
        notes("internal_notes"),
        status("Choose Status"),
        issueId("Issue ID");
        private String value;

        PLACEHOLDER(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    public static String DEFAULT_PROJECT = "Choose Project";
    public static String DEFAULT_SELECT_PROJECT = "Select Project";
    public static String DEFAULT_INITIATIVE= "Choose Initiative";
    public static String DEFAULT_GOAL = "Choose Goal";
    public static String DEFAULT_CUSTOMER_SOURCE = "Choose Customer Source";
    public static String DEFAULT_ACCOUNT_CODE = "Choose Account";
    public static String DEFAULT_VISIBILITY = "Choose Visibility";
    public static String DEFAULT_PRODUCT = "Choose Product";
    public static String DEFAULT_COUPON = "Choose Coupon";
    public static String DEFAULT_NEWSSTAND = "Choose Newsstand";
    public static String DEFAULT_REASON = "Choose Reason";
    public static String DEFAULT_CONTENT_RATING = "Choose Content Rating";
    public static String DEFAULT_PARENT = "Choose Parent";
    public static String DEFAULT_CIRCULATION_TYPE = "Choose Circulation Type";
    public static String DEFAULT_PUBLICATION_PARENT = "Choose Publication Parent";
}