package com.zinio.web.data;

/**
 * Created by long.tran on 8/4/17.
 */
public class CampaignData {
    public static String CAMPAIGN_CREATE_TITLE = "Create new campaign";
    public static String[] CAMPAIGN_REQUIRED_FIELDS = {"Title", "Project", "Start Date", "End Date", "Initiative"
            , "Goal", "Customer Source", "Account", "Visibility", "Short Code", "Channel"};
    public static String[] CAMPAIGN_STATUSES = {"Draft", "Active", "Schedule", "Archived", "Inactive", "Retracted"};
    public static String[] CAMPAIGN_PROJECT = {"Zinio Newsstand", "Sanoma", "Relay"};
    public static String[] CAMPAIGN_HOUR = {"00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00",
            "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30",
            "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00",
            "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30"};
    public static String[] CAMPAIGN_INITIATIVE = {"2018-Q1", "2018-Q2", "2018-Q3", "2018-Q4"};
    public static String[] CAMPAIGN_CUSTOMER_SOURCE = {"Zinio","Internal", "Publisher", "Reseller", "Partner"};
    public static String[] CAMPAIGN_GOAL = {"Acquisition", "Engagement", "Upsell", "Renew", "Winback"};
    public static String[] CAMPAIGN_GOAL_SORT_TYPE = {"acq", "eng", "ups", "ren", "win"};
    public static String[] CAMPAIGN_DEFAULT_ACCOUNT_CODE = {"Zinio", "Sanoma", "Relay"};
    public static String[] CAMPAIGN_VISIBILITY = {"Hidden", "Public"};
    public static String[] CAMPAIGN_CHANNEL = {"Banners", "Email", "Social", "Paid Ads", "Mobile Ads"};
    public static String CAMPAIGN_BULK_ADD_TITLE = "Bulk Add";
    public static String CAMPAIGN_BULK_VALID_CSV_FILE = "/src/test/java/testData/campaigntargetsbulk/validFile.csv";
    public static String CAMPAIGN_BULK_ACTIONS_WRONG_FORMAT =
            "/src/test/java/testData/campaigntargetsbulk/invalidFormatCSV.csv";
    public static String CAMPAIGN_BULK_ACTIONS_BIG_DATA = "/src/test/java/testData/campaigntargetsbulk/bigData.csv";
    public static String CAMPAIGN_BULK_INVALID_PUBLICATION =
            "/src/test/java/testData/campaigntargetsbulk/InvalidPublicationData.csv";
    public static String CAMPAIGN_BULK_EMPTY_DATA =
            "/src/test/java/testData/campaigntargetsbulk/emptyCSV.csv";
    public static String CAMPAIGN_BULK_INVALID_STATUS =
            "/src/test/java/testData/campaigntargetsbulk/InvalidStatus.csv";
    public static String CAMPAIGN_BULK_INVALID_COUPON =
            "/src/test/java/testData/campaigntargetsbulk/InvalidCoupon.csv";

    public enum CAMPAIGN_TARGET_PUBLICATION_STATUS {Active, Inactive}
    public enum COUPON_STATUS {Active,Disabled}

    public static String CAMPAIGN_AGGREGATED_CODE_FORMAT = "{0}.{1}.{2}.{3}.{4}.{5}";
    public static int CAMPAIGN_TITLE_MAX_LENGTH = 255;
    public static int CAMPAIGN_DESCRIPTION_MAX_LENGTH = 512;
    public static int CAMPAIGN_SHORT_CODE_MAX_LENGTH = 16;
    public static String statusColumn = "7";
    public static String[] CAMPAIGN_SEARCH_CONDITION = {"Title", "Code", "Short Code", "Project ID"};
    public static String[] CAMPAIGN_INITIATIVE_IN_SEARCH = {"2016-Q4", "2017-Q1", "2017-Q2", "2017-Q3", "2017-Q4",
            "2018-Q1",
            "2018-Q2",
            "2018-Q3",
            "2018-Q4"};
    public static String[] CAMPAIGN_DEFAULT_COLUMNS = {"Title", "ID", "Project ID", "Status", "Code"};
    public static String[] CAMPAIGN_IRREMOVABLE_COLUMNS = {"Title", "ID"};
    public static String[] CAMPAIGN_PROJECT_ID = {"99", "1122", "1003"};
    public static String CAMPAIGN_AGGREGATED_CODE_FORMAT_SEARCH = "{0}.{1}.{2}.{3}.{4}";
    public static String COUPON_SPONSORED_RATE_OTHER_VALUE = "Other";
    public static String[] CAMPAIGN_COUPON_DEFAULT_COLUMNS = {"Name", "ID", "Amount", "Status"};
    public static String[] COUPON_TYPE = {"Percent Off", "Amount Of", "Extra Issues", "Back Issues", "Buy X get Y"};
    public static String[] COUPON_IRREMOVABLE_COLUMNS = {"Name", "ID"};

    public static String[] TARGET_PUBLICATION_DEFAULT_COLUMNS = {"Name", "ID", "Status"};
}
