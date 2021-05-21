package com.zinio.web.data;

import com.zinio.web.utilities.StringUtils;

public class PublisherData {
    public static String[] PUBLISHER_STATUSES = {"Active", "Inactive"};
    public static String[] PUBLISHER_FILTERS = {"Publisher Name", "Remote ID", "Country code"};
    public static String[] PUBLISHER_STATUS_FILTERS = StringUtils.addStringToArray(PUBLISHER_STATUSES, "Status: All");

    public static String[] PUBLISHER_REQUIRED_FIELDS = {"Name", "Internal Name", "Status", "Country"};
    public static String[] PUBLISHER_DEFAULT_COLUMNS = {"Internal Name", "ID", "Country Code", "Status"};
    public static String[] PUBLISHER_IRREMOVABLE_COLUMNS = {"Internal Name", "ID"};
    public static String PUBLISHER_AUTOMATION_NAME = "PublisherAutoDoNotTouch";



}
