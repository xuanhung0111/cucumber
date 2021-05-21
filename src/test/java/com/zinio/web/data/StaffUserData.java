package com.zinio.web.data;

/**
 * Created by hoangnguyen on 6/23/17.
 */
public class StaffUserData {
    public static String USER_CREATE_PAGE_TITLE = "Add user";
    public static String EMAIL_INBOX = "autotest@mailinator.com";
    public static String EMAIL_SUFFIX_ZINIO = "@zinio.com";
    public static String[] STAFF_USER_STATUSES = {"Disabled", "Enable"};
    public static String STAFF_USER_FIRSTNAME_IS_REQUIRED = "First Name cannot be empty.";
    public static String STAFF_USER_LASTNAME_IS_REQUIRED = "Last Name cannot be empty.";
    public static String STAFF_USER_EMAIL_IS_REQUIRED = "Email cannot be empty.";
    public static String STAFF_USER_EMAIL_IS_INVALID_FORMAT = "Email is invalid.";
    public static String STAFF_USER_EMAIL_IS_NOT_UNIQUE = "This user already exists as a staff member. Please search for the user and reset his/her password.";
    public static String[] DIRECTORY_ID_RELAY_SANOMA_RECORED_BOOK = {"24", "70"};
    public static String[] STAFF_USER_REQUIRED_FIELDS = {"First Name", "Last Name", "Email"};
    public static String[] STAFF_ENTITLEMENT_FILTER = {"Project ID", "Legacy ID"};
    public static String[] STAFF_ISSUESUBS_FILTER = {"Project ID"};
    public static String[] STAFF_ISSUE_FILTER = {"Name", "ID", "Status"};
    public static String SEND_LINK_SUCCESS = "New password has been sent to ";
    public static int USERNAME_LIMITATION = 100;
    public static int PASSWORD_LIMITATION = 50;

    public enum USER_MAIN_FILTER {
        Email("Email"),
        Directory_ID("Directory ID");

        private String filterName;

        USER_MAIN_FILTER(String filterName) {
            this.filterName = filterName;
        }

        public String filterName() {
            return filterName;
        }
    }

    ;
    public static String[] USER_DEFAULT_COLUMNS = {"Email", "ID", "Directory ID", "Gender", "Status", "Directory Name"};
    public static String[] STAFF_ORDER_DEFAULT_COLUMNS = {"Order ID", "Newsstand Name", "Newsstand ID",
            "Status", "Total", "Currency", "Transacted At", "Original Order ID"};

    public static String[] ORDER_AGENT_FILTER = {"Auto-Renew", "Customer purchase", "Customer support",
            "Duplicate for device restore", "External system"};
    public static String ORDER_AGENT_DEFAULT = "Agent Type: All";
    public static String[] ORDER_SOURCE_FILTER = {"Newsstand", "CMS", "Admin", "External system", "Auto renew"};
    public static String ORDER_SOURCE_DEFAULT = "Source Type: All";
    public static String[] ORDER_STATUS_FILTER = {"Cancelled", "Invalid", "Pending", "Processing", "Fulfilled"};
    public static String ORDER_STATUS_DEFAULT = "Status: All";

    public static String[] USER_IRREMOVABLE_COLUMNS = {"ID"};
    public static String[] VALID_DIRECTORY = {"1", "2", "3"};
    public static String existedEmail = "adminautotest@zinio.com";
    public static String[] USER_ENTITLEMENT_DEFAULT_COLUMNS = {"ID", "Issue", "Issue ID", "Issue Status",
            "Publication", "Publication ID", "Project ID", "Order ID", "Subscription ID", "Delivery ID", "Legacy ID",
            "Type", "Status", "Created At", "Label Type"};

    public static String[] USER_SUBSCRIPTION_DEFAULT_COLUMNS = {"ID", "Project ID", "Publication", "Term Amount",
            "Term Unit", "Issues Delivered", "Issues Remaining", "Auto Renew", "Status", "Publication ID"};

    public static String urlPaymentProfile = "https://stg-api.ziniopro.com/commerce/v2/userpaymentprofiles";
    public static String projectId = "99";
    public static String newsstandId = "101";
    public static String applicationID = "881";
    public static String[] publicationName = {"Digital Photo Pro", "Engage Media_Vet Practice"};
    public static String titleResetPassword = "Reset your password";

    public static String titleCheckYourEmail = "Check your email";
    public static String titleCreateNewPassword = "Create a New Admin Password";
    public static String titleResetSuccess = "Success!";
    public static String titleSelectIssue = "Select Issues - Limit 10 ({0})";
}
