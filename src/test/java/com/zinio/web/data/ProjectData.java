package com.zinio.web.data;
import com.zinio.web.utilities.StringUtils;

public class ProjectData {
    public static String[] PROJECT_TYPES = {"Newsstand", "Vertical app", "Branded app"};
    public static String[] PROJECT_STATUSES = {"Inactive", "Active", "Suspended"};
    public static String[] PROJECT_STATUSES_NEWSSTAND = {"Inactive", "Active"};

    public static String[] PROJECT_FILTERS = {"Project Name"};
    public static String[] PROJECT_TYPE_FILTERS = StringUtils.addStringToArray(PROJECT_TYPES, "Type: All");
    public static String[] PROJECT_STATUS_FILTERS = StringUtils.addStringToArray(PROJECT_STATUSES, "Status: All");
    public static String[] PROJECT_STATUS_FILTERS_NEWSSTAND = StringUtils.addStringToArray(PROJECT_STATUSES_NEWSSTAND, "Status: All");

    public static String[] PROJECT_REQUIRED_FIELDS = {"Name", "Account Name", "Type", "Status"};
    public static String[] PROJECT_DEFAULT_COLUMNS = {"Name", "ID", "Platform", "Project", "Status"};
    public static String[] PROJECT_DEFAULT_COLUMNS_2 = {"Internal Name", "ID", "Catalog ID", "Status"};
    public static String[] PROJECT_DEFAULT_COLUMNS_3 = {"Name", "ID", "Type", "Account Name", "Status"};
    public static String[] PROJECT_IRREMOVABLE_COLUMNS = {"Name", "ID"};
    public static String PROJECT_AUTOMATION_NAME = "AutoProject";

}