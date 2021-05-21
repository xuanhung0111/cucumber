package com.zinio.web.data;

import com.zinio.web.utilities.StringUtils;

public class ApplicationData {
    public static String[] APP_PLATFORMS = {"Platform: All","WWW", "iOS", "Android", "Samsung", "Win10"};
    public static String[] APP_STATUSES = {"Status: All","Staging", "Live", "Error", "Suspended"};

    public static String[] APP_FILTERS = {"Application Name", "Project ID"};
    public static String[] APP_PLATFORM_FILTERS = StringUtils.addStringToArray(APP_PLATFORMS, "Platform: All");
    public static String[] APP_STATUS_FILTERS = StringUtils.addStringToArray(APP_STATUSES, "Status: All");



    public static String[] APP_REQUIRED_FIELDS = {"Platform", "Project", "Status"};
    public static String[] APP_DEFAULT_COLUMNS = {"Name", "ID", "Platform", "Project", "Status"};
    public static String[] APP_IRREMOVABLE_COLUMNS = {"Name", "ID"};
}
