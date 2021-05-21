package com.zinio.web.data;

public class GeneralMessageData {

    public static String TYPE_IS_REQUIRED = "Type cannot be empty.";
    public static String NAME_IS_REQUIRED = "Name cannot be empty.";
    public static String STATUS_IS_REQUIRED = "Status cannot be empty.";
    public static String COUNTRY_IS_REQUIRED = "Country cannot be empty.";
    public static String INTERNAL_NAME_IS_REQUIRED = "Internal Name cannot be empty.";
    public static String TITLE_IS_REQUIRED = "Title cannot be empty.";

    public static String ACCOUNT_CREATE_SUCCESSFUL = "Create account was successful.";
    public static String ACCOUNT_UPDATE_SUCCESSFUL = "Update account was successful.";
    public static String ACCOUNT_WEBSITE_IS_INVALID = "Website is invalid.";

    public static String APP_CREATE_SUCCESSFUL = "Create application was successful.";
    public static String APP_UPDATE_SUCCESSFUL = "Update application was successful.";
    public static String APP_PLATFORM_IS_REQUIRED = "Platform cannot be empty.";
    public static String PROJECT_IS_REQUIRED = "Project cannot be empty.";

    public static String BANNER_CREATED_MESSAGE_SUCCESSFULLY = "Create banner was successful.";
    public static String BANNER_UPDATED_MESSAGE_SUCCESSFULLY = "Update banner was successful.";
    public static String INVALID_IMAGE_MESSAGE = "The image is cannot preview";
    public static String INVALID_URL = "Invalid file type";
    public static String EXCEED_FILE_MESSAGE = "Exceed the maximum upload size. Max upload size is 1MB.";

    public static String CAMPAIGN_CREATE_SUCCESSFUL = "Create campaign was successful.";
    public static String CAMPAIGN_UPDATE_SUCCESSFUL = "Update campaign was successful.";

    public static String CATALOG_CREATE_SUCCESSFUL = "Create catalog was successful.";
    public static String CATALOG_UPDATE_SUCCESSFUL = "Update catalog was successful.";

    public static String CATEGORY_CREATE_SUCCESSFUL = "Create category was successful.";
    public static String CATEGORY_UPDATE_SUCCESSFUL = "Update category was successful.";
    public static String CATEGORY_CHANGE_PRIORITY_SUCCESSFUL = "Change priority successful.";
    public static String CATEGORY_NOT_ALLOW_SAME_PRIORITY = "Error: It should not contain same priority on same level";
    public static String CATEGORY_SET_CREATE_SUCCESSFUL = "Create category set was successful.";
    public static String CATEGORY_SET_UPDATE_SUCCESSFUL = "Update category set was successful.";
    public static String CATEGORY_UNIQUE_NAME_MESSAGE = "This name is already in same level.";

    public static String NEWSSTAND_CREATE_SUCCESSFUL = "Create newsstand was successful.";
    public static String NEWSSTAND_UPDATE_SUCCESSFUL = "Update newsstand was successful.";

    public static String NEWSSTAND_CATALOG_IS_REQUIRED = "Catalog cannot be empty.";
    public static String NEWSSTAND_RATING_MIN_IS_REQUIRED = "Content Rating Min cannot be empty.";
    public static String NEWSSTAND_RATING_MAX_IS_REQUIRED = "Content Rating Max cannot be empty.";
    public static String NEWSSTAND_LANGUAGE_IS_REQUIRED = "Language cannot be empty.";
    public static String NEWSSTAND_CURRENCY_IS_REQUIRED = "Currency cannot be empty.";
    public static String NEWSSTAND_SUPPORT_XML_IS_REQUIRED = "Support XML cannot be empty.";
    public static String NEWSSTAND_SUPPORT_PDF_IS_REQUIRED = "Support PDF cannot be empty.";
    public static String NEWSSTAND_NOT_FOUND = "Not found";


    public static String PROJECT_CREATE_SUCCESSFUL = "Create project was successful.";
    public static String PROJECT_UPDATE_SUCCESSFUL = "Update project was successful.";
    public static String PROJECT_ACCOUNT_IS_REQUIRED = "Account Name cannot be empty.";

    public static String PUBLICATION_CREATE_SUCCESSFUL = "Create publication was successful.";
    public static String PUBLICATION_UPDATE_SUCCESSFUL = "Update publication was successful.";
    public static String PUBLICATION_ASSIGN_SUCCESSFUL = "Assign successfully.";
    public static String PUBLICATION_COUNTRY_UPDATE_SUCCESSFUL = "Update successfully.";
    public static String PUBLICATION_PRINTABLE_SPREADS_IS_REQUIRED = "Printable spreads cannot be empty.";
    public static String PUBLICATION_PRINTABLE_WATERMARK_IS_REQUIRED = "Printable watermark cannot be empty.";
    public static String PUBLICATION_COUNTRY_IS_REQUIRED = "Country code cannot be empty.";
    public static String PUBLICATION_LANGUAGE_IS_REQUIRED = "Language code cannot be empty.";
    public static String PUBLICATION_BINDING_IS_REQUIRED = "Binding cannot be empty.";
    public static String PUBLICATION_FREQUENCY_IS_REQUIRED = "Frequency cannot be empty.";
    public static String PUBLICATION_PUBLISHER_IS_REQUIRED = "Publisher id cannot be empty.";
    public static String PUBLICATION_DEFAULT_CURRENCY_IS_REQUIRED = "Default Currency cannot be empty.";
    public static String PUBLICATION_RATING_IS_REQUIRED = "Content Rating cannot be empty.";
    public static String PUBLICATION_CODE_IS_NOT_UNIQUE = "Code is not unique";
    public static String PUBLICATION_ISSUES_PER_YEAR_NOT_GREATER_THAN_0 = "Issues/Year must be greater than 0";
    public static String PUBLICATION_ISSUES_PER_INVALID_VALUE = "Issues/Year is invalid.";
    public static String PUBLICATION_PRODUCT_IS_NOT_UNIQUE = "Duplicate value";
    public static String PUBLICATION_DISABLE_A_PRODUCT_MSG = "Disabling this product will affect all projects and " +
            "default products.";
    public static String PUBLICATION_UNASSIGN_CATALOG_MSG = "Do you really want to unassign selected Catalog(s)";
    public static String PUBLICATION_PRICE_UP_TIER = "Updating Tier may affect auto-renew. Do you want to continue?";
    public static String PUBLICATION_UNASSIGN_COUNTRIES = "Do you really want to unselect?";
    public static String GENERAL_SUCCESSFUL_SAVE_MESSAGE = "Save successfully";
    public static String PUBLICATION_CMS_ID_INVALID_DATA = "CMS ID must be greater than 0.";
    public static String PUBLICATION_VALIDATE_DUPLICATED_METADATA = "Name is duplicated";
    
    public static String PUBLISHER_UPDATE_SUCCESSFUL = "Update publisher was successful.";

    public static String STAFF_USER_CREATE_SUCCESSFUL = "Create user was successful.";
    public static String STAFF_USER_UPDATE_SUCCESSFUL = "Update user was successful.";
    public static String USER_CREATE_SUBSCRIPTION_SUCCESSFUL = "Create free subscription was successful";
    public static String LOGIN_VALIDATION_MESSAGE = "Please input username and password.";

    public static String STAFF_DISABLE_USER_CONFIRMATION = "Please verify subscription and autorenewals before disabling a user.";
    public static String STAFF_MERGE_USER_CONFIRMATION = "Are you sure you want to merge “{0}” to “{1}”? " +
            "All entitlements and subscriptions will also be merged.";
    public static String ENTITLEMENT_VALIDATION_MESSAGE = "means that issue is already entitled and not available for" +
            " a free entitlement";
    public static String ENTITLEMENT_CHANGE_STATUS_SUCCESS = "Status Changed.";
    public static String ORDER_ITEMS_CANCEL_SUBSCRIPTION_CONFIRMATION = "Are you sure you want to cancel this subscription?";
    public static String ORDER_ITEMS_REFUND_AFTER_CANCEL_CONFIRMATION = "Do you also want to refund? " +
            "Clicking yes will redirect you.";
    public static String ORDER_ITEMS_CANCEL_AFTER_REFUND_CONFIRMATION = "Do you also want to cancel the subscription? " +
            "Clicking yes will immediately cancel.";
    public static String ORDER_REFUND_MESSAGE_SUCCESSFUL = "Refund subscription was successful.";

    public static String FORGOT_PASSWORD_ERROR_MESSAGE = "Email is invalid.";
    public static String FORGOT_PASSWORD_VALIDATE_PWD_MSG = "Password and confirm password do not match.";
    public static String FORGOT_PASSWORD_VALIDATE_TOKEN_MSG = "The password reset token is invalid.";

    public static String INVALID_FORMAT_CSV_FILE = "CSV Error: Invalid CSV file format.";
    public static String CATALOG_INVALID_PUBLICATION_MESSAGE = "Publication could not be found in array";
    public static String UPLOAD_CSV_DEFAULT_MESSAGE = "Drop a .csv file, or browse.";
    public static String CAMPAIGN_TARGET_UPLOAD_INEXISTENT_COUPON = "The coupon is not found";
    public static String CAMPAIGN_TARGET_STOP_UPLOAD = "Are you sure you want to stop the bulk update? Completed " +
            "updates will not be removed.";
    public static String BANNER_ASSIGN_CONFIRMATION_MESSAGE = "Assignments will not be viewable after saving.";
    public static String BANNER_ASSIGN_SUCCESSFUL = "Banner assign was successful.";

    public static String CAMPAIGN_START_DATE_IS_REQUIRED_MESSAGE = "Start Date cannot be empty.";
    public static String CAMPAIGN_END_DATE_IS_REQUIRED_MESSAGE = "End Date cannot be empty.";
    public static String CAMPAIGN_INITIATIVE_IS_REQUIRED_MESSAGE = "Initiative cannot be empty.";
    public static String CAMPAIGN_GOAL_IS_REQUIRED_MESSAGE = "Goal cannot be empty.";
    public static String CAMPAIGN_CUSTOMER_SOURCE_IS_REQUIRED_MESSAGE = "Customer Source cannot be empty.";
    public static String CAMPAIGN_ACCOUNT_CODE_IS_REQUIRED_MESSAGE = "Account Code cannot be empty.";
    public static String CAMPAIGN_VISIBILITY_IS_REQUIRED_MESSAGE = "Visibility cannot be empty.";
    public static String CAMPAIGN_SHORT_CODE_IS_REQUIRED_MESSAGE = "Short Code cannot be empty.";
    public static String CAMPAIGN_SHORT_CODE_IS_INVALID_MESSAGE = "Short Code is invalid.";
    public static String CAMPAIGN_CHANNELS_IS_REQUIRED_MESSAGE = "Channel cannot be empty.";
    public static String CAMPAIGN_END_DATE_IS_LESS_THAN_START_DATE_MESSAGE = "End Date must be greater than Start" +
            " Date.";
    public static String CAMPAIGN_CANNOT_UPDATE_CUSTOMER_SOURCE_MESSAGE = "Cannot update customer_source when " +
            "campaign was activated at least 1 time";
    public static String CAMPAIGN_CANNOT_UPDATE_ACCOUNT_CODE_MESSAGE = "Cannot update account_code when campaign was " +
            "activated at least 1 time";
    public static String CAMPAIGN_TARGET_VALIDATION_MESSAGE = "Please choose Product";
    public static String COUPON_CREATE_SUCCESSFULLY_MESSAGE = "Create coupon was successful.";
    public static String COUPON_UPDATE_SUCCESSFULLY_MESSAGE = "Update coupon was successful.";
    public static String COUPON_VALIDATION_SPONSORED_RATE = "Percentage cannot be less than 0 or greater than 100.";
    public static String COUPON_CHECK_EXIST_SPONSORED_RATE = "Sponsored rate already exists. Please select from dropdown";
    public static String COUPON_AMOUNT_VALIDATION_MESSAGE = "Amount cannot be empty.";
    public static String COUPON_CANNOT_UPDATE_STATUS_MESSAGE = "Cannot change Status to <Disabled> when this Coupon " +
            "is used by at least Active Target";

    public static String ORDER_REASON_VALIDATION_MESSAGE = "Reason cannot be empty.";
    public static String INTERNAL_NOTE_VALIDATION_MESSAGE = "Internal notes cannot be empty.";
}