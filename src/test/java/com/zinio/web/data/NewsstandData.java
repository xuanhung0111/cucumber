package com.zinio.web.data;

import com.zinio.web.utilities.StringUtils;

public class NewsstandData {
    public static String[] NEWSSTAND_STATUSES = {"Active", "Inactive"};
    public static String[] NEWSSTAND_RATING_MIN = {"G", "PG", "PG-13", "R", "R2", "XS", "XG"};
    public static String[] NEWSSTAND_RATING_MAX = NEWSSTAND_RATING_MIN;
    public static String[] NEWSSTAND_SUPPORT_XML = {"Yes", "No"};
    public static String[] NEWSSTAND_SUPPORT_PDF = NEWSSTAND_SUPPORT_XML;

    public static String[] NEWSSTAND_FILTERS = {"Project ID", "Catalog ID"};
    public static String[] NEWSSTAND_FILTERS_PROJECT_DETAIL = {"Catalog ID"};
    public static String[] NEWSSTAND_STATUS_FILTERS = StringUtils.addStringToArray(NEWSSTAND_STATUSES, "Status: All");

    public static String[] NEWSSTAND_REQUIRED_FIELDS = {
            "Name", "Internal Name", "Project", "Catalog", "Rating Min", "Rating Max", "Country",
            "Language", "Status", "Currency", "Support XML", "Support PDF"};
    public static String[] NEWSSTAND_DEFAULT_COLUMNS
            = {"Internal Name", "ID", "Catalog ID", "Project ID", "Status"};
    public static String[] NEWSSTAND_ISSUES = {"Name", "ID", "Go-live Date", "Status"};
    public static String[] NEWSSTAND_WEEKLIES_DEFAULT_COLUMN = {"Internal Name", "ID", "Publisher Name"};
    public static String[] NEWSSTAND_DEFAULT_COLUMNS_PROJECT_DETAILS
            = {"Internal Name", "ID", "Catalog ID", "Status"};
    public static String[] NEWSSTAND_IRREMOVABLE_COLUMNS = {"Internal Name", "ID"};
    public static String[] NEWSSTAND_LISTS = {"Featured", "Top Sellers", "New Arrivals", "Explore Articles"};
    public static String[] NEWSSTAND_DEFAULT_COLUMN = {"Name", "ID", "Publisher", "Country"};
    public static String[] ZINIO_NEWSSTANDS_LIST = {
            "Choose List", "Explore Articles", "Featured", "Free Publications",
            "New Arrivals", "News Weeklies", "Top Sellers"};
    public static String[] SANOMA_NEWSSTANDS_LIST = {
            "Choose List", "Explore Articles", "New Arrivals", "Popular"};
    public static String[] RELAY_NEWSSTANDS_LIST = {
            "Choose List", "Featured", "Top Seller", "New Arrivals", "Explore Articles"};

    public static String TESTDATA_PUBLICATIONS = "Maxim";
    public static String TESTDATA_PUBLICATIONS_FILTER = "ESPN";
    public static String TESTDATA_COUNTRY = "United States";
    public static String BANNER_LIST_DEFAULT = "Choose Banner List";
    public static String NEWSSTAND_LIST_API = "https://stg-admin-backend.zinio" +
            ".com/v1/newsstand/newsstands/{0}/lists/{1}?access_token={2}";
    public static String ZINIO_PROJECT_ID = "99";
    public static String ZINIO_NEWSSTAND_NAME = "Zinio USA";
    public static String ZINIO_NEWSSTAND_ID = "101";

    public static String[] NEWSSTAND_BANNER_LIST = {"Storefront Banners", "Library Banners", "Shop Banners"};
    public static String[] RELAY_NEWSSTAND_BANNER_LIST = {"Storefront Banners"};
    public static String[] SANOMA_NEWSSTAND_BANNER_LIST = {"Storefront Banners"};
    public static String NEWSSTAND_DETAIL_URL = "/newsstands/{0}";
}