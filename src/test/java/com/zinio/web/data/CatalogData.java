package com.zinio.web.data;
import com.zinio.web.utilities.PropertyUtils;
import com.zinio.web.utilities.StringUtils;

public class CatalogData {
    public static String[] CATALOG_STATUSES = {"Active", "Inactive"};

    public static String[] CATALOG_FILTERS = {"Catalog Name"};
    public static String[] CATALOG_STATUS_FILTERS = StringUtils.addStringToArray(CATALOG_STATUSES, "Status: All");

    public static String[] CATALOG_REQUIRED_FIELDS = {"Name", "Status"};
    public static String[] CATALOG_DEFAULT_COLUMNS = {"Name", "ID", "Status"};
    public static String[] CATALOG_IRREMOVABLE_COLUMNS = {"Name", "ID"};
    public static String[] PUBLICATION_STATUS_IN_CATALOG = {"Publication Status: All","Disabled", "Enabled"};
    public static String CATALOG_PUBLICATION_BULK_ACTIONS_TITLE = "Bulk Edit";
    public static String CATALOG_BULK_VALID_CSV_FILE = "/src/test/java/testData/catalogbulk/validFile.csv";
    public static String CATALOG_BULK_ACTIONS_WRONG_FORMAT = "/src/test/java/testData/catalogbulk/invalidFormatCSV.csv";
    public static String CATALOG_BULK_ACTIONS_BIG_DATA = "/src/test/java/testData/catalogbulk/bigData.csv";
    public static String CATALOG_BULK_INVALID_PUBLICATION =
            "/src/test/java/testData/catalogbulk/InvalidPublicationData.csv";

    public enum CATALOG_PUBLICATION_STATUS {
        Unassigned,
        Assigned,
        Invalid
    }

    public enum ACTION_STATUS {Assign, Unassign};

    public static String[] CATALOG_BULK_IMPORT_STATUS = {"Error","Completed"};

    public static int timeout = PropertyUtils.getPropAsInt("timeToWaitSelectBox");
}