package com.zinio.web.data;

import com.zinio.web.utilities.StringUtils;

public class PublicationData {
    public static String[] PUBLICATION_TYPES = {"Magazine", "Newspaper", "Book", "TextBook", "Journal"};
    public static String[] PUBLICATION_PRINTABLE_SPREADS = {"Yes", "No"};
    public static String[] PUBLICATION_PRINTABLE_WATERMARK = {"Yes", "No"};
    public static String[] PUBLICATION_BINDINGS = {"Left to right", "Right to left"};
    public static String[] PUBLICATION_FREQUENCIES = {"One-off (Once)", "Daily (Once everyday)", "Weekly (Once every week)", "Biweekly (Once every two weeks)",
            "Monthly (Once a month)", "Bimonthly (Once every two months)", "Quarterly (Once every three months)",
            "Biannually (Once every six months)", "Yearly (Once a year)", "Other (unknown)", "Unknown (unknown)", "Suspended"};
    public static String[] PUBLICATION_RATINGS = {"G", "PG", "PG-13", "R", "R2"};

    public enum PUBLICATION_STATUSES {Enabled, Disabled}

    public static String[] PUBLICATION_CIRCULATION_TYPES = {"n/a", "Paid", "Controlled", "Mixed", "Free"};

    public static String[] PUBLICATION_FILTERS = {"Publication Name", "Publication ID", "Publisher ID", "Category ID", "Remote ID", "ISSN"};
    public static String[] PUBLICATION_TAB_FILTERS = {"Publication Name", "Legacy Identifier", "Catalog ID"};
    public static String[] PUBLICATION_STATUS_FILTERS = StringUtils.addStringToArray(StringUtils.parseEnumToArrayList(PUBLICATION_STATUSES.class), "Status: All");
    public static String[] PUBLICATION_COUNTRY_FILTERS = StringUtils.addStringToArray(StringUtils.getColumnsValueOn2DArray(GeneralData.COUNTRY, 0), "Country: All");


    public static String[] PUBLICATION_REQUIRED_FIELDS = {"Display Name", "Type", "Printable Spreads", "Printable Watermark",
            "Country", "Language", "Binding", "Frequency", "Publisher", "Rating", "Status", "Default Currency"};
    public static String[] PUBLICATION_DEFAULT_COLUMNS = {"Internal Name", "ID", "Publisher Name", "Country", "Status", "CMS Link"};
    public static String[] PRODUCT_DEFAULT_COLUMNS = {"ID", "Name", "Code", "Description", "Status"};
    public static String[] PRODUCT_IRREMOVABLE_COLUMNS = {"Name", "Status"};
    public static String[] PUBLICATION_IRREMOVABLE_COLUMNS = {"Internal Name", "ID"};
    public static String[] CATALOG_IRREMOVABLE_COLUMNS = {"Name", "ID"};
    public static String[] PRICE_TIERS_DEFAULT_COLUMNS = {"Norway (NO)", "Hungary (HU)", "Portugal (PT)", "Poland (PL)"
            , "Ireland (IE)", "Greece (GR)", "Slovenia (SI)", "Italy (IT)", "Spain (ES)", "Netherlands (NL)", "Lithuania (LT)"
            , "Latvia (LV)", "Unknown (CS)", "Belgium (BE)", "Slovakia (SK)", "Estonia (EE)", "Bulgaria (BG)", "Austria (AT)"
            , "France (FR)", "Germany (DE)", "Cyprus (CY)", "Malta (MT)", "Luxembourg (LU)", "Unknown (EU)", "Finland (FI)"
            , "Switzerland (CH)", "Sweden (SE)", "Denmark (DK)", "Unknown (UK)", "United Arab Emirates (AE)", "Saudi Arabia (SA)"
            , "South Africa (ZA)", "Israel (IL)", "Turkey (TR)", "Russia (RU)", "India (IN)", "Indonesia (ID)", "Taiwan (TW)"
            , "Hong Kong SAR China (HK)", "Singapore (SG)", "China (CN)", "Japan (JP)", "New Zealand (NZ)", "Australia (AU)"
            , "Mexico (MX)", "Canada (CA)"
            , "United States (US)", "Romania (RO)"};
    public static String[] DEFAULT_PUBLICATION_COLUMN = {"Name", "ID", "Publisher", "Country"};
    public static String FORMAT_PRODUCT_CODE = "pub{0}.{1}issues";
    public static String FORMAT_CODE = "{0}issues";
    public static String FORMAT_PRODUCT_DESCRIPTION = "{0}-issue subscription to {1}";
    public static String FORMAT_PUBLICATION_CMS_LINK = "http://site-{0}.audiencemedia.com";
    public static int CMS_ID_NUMBER = 2000000000;
    public static int PRODUCT_MAX_ISSUE_NR = 999;

    public enum PRODUCT_ALLOWED_COLUMNS_UPDATE {Name, Description}

    //Price tab
    public static int MIN_PRICE_TIER = 0;
    public static int MAX_PRICE_TIER = 87;
    //Select Tier2 -> Tier 5 does not show popup
    public static int MIN_PRICE_EQUAL_TIER = 2;
    public static int MAX_PRICE_EQUAL_TIER = 5;
    public static String PREFIX_TIER_A = "Tier ";
    public static String PREFIX_TIER_B = "Tier alternate_";
    public static int NO_TIER_VALUE = -1;
    public static String NO_TIER = "No Tier";
    public static String[] PUBLICATION_DEFAULT_TABS = {"General Information", "Categories", "Catalogs", "Countries",
            "Products", "Prices", "Issue Prices"};
    public static String[] PUBLICATION_IRREMOVABLE_TABS = {"General Information"};

    // Catalog tab =====================================================================================================
    public static String[] DEFAULT_ASSIGN_CATALOG_COLUMNS = {"Name", "ID"};

    // Metadata tab ====================================================================================================
    public static String[] PRESET_OPTIONS = {"Genre", "BISAC Code"};
    public static String[] PRESET_VALUES = {"genre", "bisac_code"};
    public static String DEFAULT_PRESET_VALUE = "Choose an option";
    public static String[] GENRE_OPTIONS = {"General", "Adaptations", "Anthologies", "Humor", "Contemporary Women",
            "Crime & Mystery", "Dystopian", "Erotica", "Fantasy", "Historical Fiction", "Horror", "Juvenile Fiction",
            "Juvenile Nonfiction", "LGBT", "Literary", "Manga", "Manga / Crime & Mystery", "Manga / Dystopian", "Manga / " +
            "Erotica & Hentai", "Manga / Fantasy", "Manga / Historical Fiction", "Manga / Horror", "Manga / LGBT", "Manga " +
            "/ Media Tie-In", "Manga / Nonfiction", "Manga / Romance", "Manga / Science Fiction", "Manga / Sports", "Manga" +
            " / Yaoi", "Media Tie-In", "Nonfiction", "Nonfiction / Biography & Memoir", "Religious", "Romance", "Science " +
            "Fiction", "Superheroes", "Art Techniques", "Young Adult Fiction", "Young Adult Nonfiction"};
    public static String[] BISAC_OPTIONS = {"CGN012000","CGN001000","HUM001000","CGN008000","CGN004010","CGN013000",
            "CGN004020","CGN004030","CGN010000","CGN004040","JUV008000","JNF062000","CGN009000","CGN006000",
            "CGN004050","CGN004100","CGN004230","CGN004110","CGN004120","CGN004140","CGN004150","CGN004130",
            "CGN004160","CGN004170","CGN004180","CGN004190","CGN004200","CGN004210","CGN004060","CGN007000",
            "CGN007010","CGN011000","CGN004090","CGN004070","CGN004080","ART004000","YAF010000","YAN012000"};
    public static String[] METADATA_MODE = {"Create","Update"};
}
