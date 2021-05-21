package com.zinio.web.data;

import com.zinio.web.utilities.StringUtils;

public class AccountData {
    public static String[] ACCOUNT_TYPES = {"Unclassified", "Partner", "Publisher", "Library", "Reseller", "Franchisee"};
    public static String[] ACCOUNT_TIERS = {"Tier 1", "Tier 2", "Tier 3"};
    public static String[] ACCOUNT_STATUSES = {"Disabled", "Enabled"};

    public static enum PROJECT_STATUSES {Inactive, Active, Suspended};
    public static String[] PROJECT_TYPES = {"Newsstand", "Vertical app", "Branded app"};

    public static String[] ACCOUNT_MAIN_FILTERS = {"Account Name", "Parent ID"};
    public static String[] ACCOUNT_CHILD_FILTERS = {"Account Name"};
    public static String[] ACCOUNT_TYPE_FILTERS = StringUtils.addStringToArray(ACCOUNT_TYPES, "Type: All");
    public static String[] ACCOUNT_TIER_FILTERS = StringUtils.addStringToArray(ACCOUNT_TIERS, "Tier: All");
    public static String[] ACCOUNT_STATUS_FILTERS = StringUtils.addStringToArray(ACCOUNT_STATUSES, "Status: All");

    public static String ACCOUNT_AUTOMATION_NAME = "AccountAutoDoNotTouch";


    public static String[] ACCOUNT_REQUIRED_FIELDS = {"Account Name", "Type", "Status"};
    public static String[] ACCOUNT_DEFAULT_COLUMNS = {"Name", "ID", "Type", "Tier", "Status"};
    public static String[] ACCOUNT_IRREMOVABLE_COLUMNS = {"Name", "ID"};

    public static String ACC_PAYABLECODE = "_AP";
    public static String ACC_RECEIVABLECODE = "_AR";
}