package com.zinio.web.data;
import com.zinio.web.utilities.StringUtils;

public class CategorySetData {
    public static String[] CATEGORY_SET_STATUSES = {"Active", "Inactive"};
    public static String[] CATEGORY_SET_TYPES = {"Zinio default", "Custom"};

    public static String[] CATEGORY_SET_FILTERS = {"Category Set Name"};
    public static String[] CATEGORY_SET_STATUS_FILTERS = StringUtils.addStringToArray(CATEGORY_SET_STATUSES, "Status: All");
    public static String[] CATEGORY_SET_TYPE_FILTERS = StringUtils.addStringToArray(CATEGORY_SET_TYPES, "Type: All");

    public static String[] CATEGORY_SET_REQUIRED_FIELDS = {"Category Set Name", "Type", "Status"};
    public static String[] CATEGORY_SET_DEFAULT_COLUMNS = {"Name", "ID", "Type", "Status"};
    public static String[] CATEGORY_SET_IRREMOVABLE_COLUMNS = {"Name", "ID"};
    public static String CATEGORY_SET_AUTOMATION_NAME = "CategorySetAuto";
}
