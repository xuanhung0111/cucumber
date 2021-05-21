package com.zinio.web.data;

/**
 * Created by khanh.le on 11/14/17.
 */
public class OrderData {

    public enum SUBSCRIPTION_STATUS {Pending, Cancelled}

    public static String apiURLOrder = "https://stg-api.ziniopro.com/commerce/v2/orders";

    public static String productIdStandard = "351726";

    public static String priceIdStandard = "17369";

    public static String[] ORDER_ITEMS_DEFAULT_COLUMNS = {"Order Item ID", "Product Type", "Publication Name",
            "Issue Name", "Newsstand Name", "Transacted Price", "Discount Amount", "Tax Amount", "Currency", "Status"};
    public static String ORDER_SINGLE_REFUND_ORDER = "Refund Single Issue ({0})";
    public static String ORDER_SUBSCRIPTION_REFUND_ORDER = "Refund Subscription ({0})";
    public static String[] ORDER_REASONS = {"Unsatisfied with Zinio", "Accidental auto-renew",
            "Technical incompatibility", "Wrong language", "No reason given",
            "Unauthorized charges", "Inconsistent delivery", "Duplicate purchase", "Zinio internal test purchase",
            "Wanted print"};
}
