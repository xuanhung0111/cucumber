package com.zinio.web.data;

public class GeneralData {
    public static String NOT_FOUND_MESSAGE = "Not Found";
    public static String STRANGE_VALUE = "~`!@#%^&*()-_=+[{]}|;:\",<.>/?";
    public static String[] PAGINATION = {"5 items", "10 items", "20 items", "50 items", "100 items"};
    public static int NUMBER_TO_TEST_LANDING_PAGE = 11;
    public static String ZERO = "0";
    public static String BLANK_SPACE = "   ";
    public static String ASCENDING = "Ascending";
    public static String DESCENDING = "Descending";
    public static String DATE_FORMAT = "yyyy-MM-dd";
    public static String DATE_FORMAT_VN = "dd/MM/yy";
    public static String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm";
    public static String USERNAME = "khanh.le+1@zinio.com";
    public static String PASSWORD = "devteam";
    public static String USERNAME_SANOMA = "sanoma_staff@zinio.com";
    public static String PASSWORD_SANOMA = "sanoma123";
    public static String USERNAME_RELAY = "daitran1104@gmail.com";
    public static String PASSWORD_RELAY = "devteam";
    public static String NAME_TEXTBOX_PLACEHOLDER = "Name";
    public static String INTERNAL_NOTES_TEXTBOX_PLACEHOLDER = "Internal Notes";
    public static String APPLICATION_NAME_TEXTBOX_PLACEHOLDER = "Application Name";
    public static String DESCRIPTION_TEXTBOX_PLACEHOLDER = "Description";
    public static String URL_TEXTBOX_PLACEHOLDER = "Url";
    public static String INTERNAL_NAME_TEXTBOX_PLACEHOLDER = "Internal Name";
    public static String DISPLAY_NAME_TEXTBOX_PLACEHOLDER = "Display Name";
    public static String LATIN_NAME_TEXTBOX_PLACEHOLDER = "Latin Name";
    public static String SEO_KEYWORDS_TEXTBOX_PLACEHOLDER = "SEO Keywords";
    public static String LOGO_TEXTBOX_PLACEHOLDER = "Logo";
    public static String CODE_TEXTBOX_PLACEHOLDER = "Code";
    public static String SLUG_TEXTBOX_PLACEHOLDER = "Slug";
    public static String ISSUE_YEAR_TEXTBOX_PLACEHOLDER = "Issue/Year";
    public static String TAGLINE_TEXTBOX_PLACEHOLDER = "Tagline";
    public static String ISSN_TEXTBOX_PLACEHOLDER = "ISSN";
    public static String FULLFILMENT_CODE_TEXTBOX_PLACEHOLDER = "Fulfilment Code";
    public static String CATEGORY_SET_NAME_TEXTBOX_PLACEHOLDER = "Category Set Name";
    public static String CATEGORY_NAME_TEXTBOX_PLACEHOLDER = "Category Name";
    public static String IMAGE_TEXTBOX_PLACEHOLDER = "Image";
    public static String[][] COUNTRY = {
            {"Afghanistan", "AF"}, {"Albania", "AL"}, {"Algeria", "DZ"}, {"American Samoa", "AS"}, {"Andorra", "AD"}, {"Angola", "AO"}
            , {"Anguilla", "AI"}, {"Antarctica", "AQ"}, {"Antigua and Barbuda", "AG"}, {"Argentina", "AR"}, {"Armenia", "AM"}, {"Aruba", "AW"}
            , {"Australia", "AU"}, {"Austria", "AT"}, {"Azerbaijan", "AZ"}, {"Bahamas", "BS"}, {"Bahrain", "BH"}, {"Bangladesh", "BD"}
            , {"Barbados", "BB"}, {"Belarus", "BY"}, {"Belgium", "BE"}, {"Belize", "BZ"}, {"Benin", "BJ"}, {"Bermuda", "BM"}, {"Bhutan", "BT"}
            , {"Bolivia", "BO"}, {"Bosnia and Herzegovina", "BA"}, {"Botswana", "BW"}, {"Bouvet Island", "BV"}, {"Brazil", "BR"}
            , {"British Indian Ocean Territory", "IO"}, {"Brunei Darussalam", "BN"}, {"Bulgaria", "BG"}, {"Burkina Faso", "BF"}, {"Burundi", "BI"}
            , {"Cambodia", "KH"}, {"Cameroon", "CM"}, {"Canada", "CA"}, {"Cape Verde", "CV"}, {"Cayman Islands", "KY"}
            , {"Central African Republic", "CF"}, {"Chad", "TD"}, {"Chile", "CL"}, {"China", "CN"}, {"Christmas Island", "CX"}
            , {"Cocos (Keeling) Islands", "CC"}, {"Colombia", "CO"}, {"Comoros", "KM"}, {"Congo", "CG"}
            , {"Congo, The Democratic Republic of the", "CD"}, {"Cook Islands", "CK"}, {"Costa Rica", "CR"}, {"Croatia", "HR"}
            , {"Cuba", "CU"}, {"Cyprus", "CY"}, {"Czech Republic", "CZ"}, {"Denmark", "BK"}, {"Djibouti", "DJ"}, {"Dominica", "DM"}
            , {"Dominican Republic", "DO"}, {"Ecuador", "EC"}, {"Egypt", "EG"}, {"El Salvador", "SV"}, {"Equatorial Guinea", "GQ"}
            , {"Eritrea", "ER"}, {"Estonia", "EE"}, {"Ethiopia", "ET"}, {"Falkland Islands (Malvinas)", "FK"}, {"Faroe Islands", "FO"}
            , {"Fiji", "FJ"}, {"Finland", "FI"}, {"France", "FR"}, {"French Guiana", "GF"}, {"French Polynesia", "PF"}
            , {"French Southern Territories", "TF"}, {"Gabon", "GA"}, {"Gambia", "GM"}, {"Georgia", "GE"}, {"Germany", "DE"}, {"Ghana", "GH"}
            , {"Gibraltar", "GI"}, {"Greece", "GR"}, {"Greenland", "GL"}, {"Grenada", "GD"}, {"Guadeloupe", "GP"}, {"Guam", "GU"}, {"Guatemala", "GT"}
            , {"Guernsey", "GG"}, {"Guinea", "GN"}, {"Guinea-Bissau", "GW"}, {"Guyana", "GY"}, {"Haiti", "HT"}
            , {"Heard Island and Mcdonald Islands", "HM"}, {"Holy See (Vatican City State)", "VA"}, {"Honduras", "HN"}, {"Hong Kong", "HK"}
            , {"Hungary", "HU"}, {"Iceland", "IS"}, {"India", "IN"}, {"Indonesia", "ID"}, {"Iran, Islamic Republic Of", "IR"}, {"Iraq", "IQ"}
            , {"Ireland", "IE"}, {"Isle of Man", "IM"}, {"Israel", "IL"}, {"Italy", "IT"}, {"Jamaica", "JM"}, {"Japan", "JP"}, {"Jersey", "JE"}
            , {"Jordan", "JO"}, {"Kazakhstan", "KZ"}, {"Kenya", "KE"}, {"Kiribati", "KI"}, {"Korea, Republic of", "KR"}, {"Kuwait", "KW"}
            , {"Kyrgyzstan", "KG"}, {"Latvia", "LV"}, {"Lebanon", "LB"}, {"Lesotho", "LS"}, {"Liberia", "LR"}, {"Libyan Arab Jamahiriya", "LY"}
            , {"Liechtenstein", "LI"}, {"Lithuania", "LT"}, {"Luxembourg", "LU"}, {"Macao", "MO"}, {"Macedonia, The Former Yugoslav Republic of", "MK"}
            , {"Madagascar", "MG"}, {"Malawi", "MW"}, {"Malaysia", "MY"}, {"Maldives", "MV"}, {"Mali", "ML"}, {"Malta", "MT"}, {"Marshall Islands", "MH"}
            , {"Martinique", "MQ"}, {"Mauritania", "MR"}, {"Mauritius", "MU"}, {"Mayotte", "YT"}, {"Mexico", "MX"}, {"Micronesia, Federated States of", "FM"}
            , {"Monaco", "MC"}, {"Mongolia", "MN"}, {"Montserrat", "MS"}, {"Morocco", "MA"}, {"Mozambique", "MZ"}, {"Myanmar", "MM"}, {"Namibia", "NA"}
            , {"Nauru", "NR"}, {"Nepal", "NP"}, {"Netherlands", "NL"}, {"Netherlands Antilles", "AN"}, {"New Caledonia", "NC"}, {"New Zealand", "NZ"}
            , {"Nicaragua", "NI"}, {"Niger", "NE"}, {"Nigeria", "NG"}, {"Niue", "NU"}, {"Norfolk Island", "NF"}, {"Northern Mariana Islands", "MP"}
            , {"Norway", "NO"}, {"Oman", "OM"}, {"Pakistan", "PK"}, {"Palau", "PW"}, {"Palestinian Territory, Occupied", "PS"}, {"Panama", "PA"}
            , {"Papua New Guinea", "PG"}, {"Paraguay", "PY"}, {"Peru", "PE"}, {"Philippines", "PH"}, {"Pitcairn", "PN"}, {"Poland", "PL"}
            , {"Portugal", "PT"}, {"Puerto Rico", "PR"}, {"Qatar", "QA"}, {"Reunion", "RE"}, {"Romania", "RO"}, {"Russian Federation", "RU"}
            , {"RWANDA", "RW"}, {"Saint Helena", "SH"}, {"Saint Kitts and Nevis", "KN"}, {"Saint Lucia", "LC"}, {"Saint Pierre and Miquelon", "PM"}
            , {"Saint Vincent and the Grenadines", "VC"}, {"Samoa", "WS"}, {"San Marino", "SM"}, {"Sao Tome and Principe", "ST"}
            , {"Saudi Arabia", "SA"}, {"Senegal", "SN"}, {"Serbia and Montenegro", "CS"}, {"Seychelles", "SC"}, {"Sierra Leone", "SL"}, {"Singapore", "SG"}
            , {"Slovakia", "SK"}, {"Slovenia", "SI"}, {"Solomon Islands", "SB"}, {"Somalia", "SO"}, {"South Africa", "ZA"}
            , {"South Georgia and the South Sandwich Islands", "GS"}, {"Spain", "ES"}, {"Sri Lanka", "LK"}, {"Sudan", "SD"}, {"Suriname", "SR"}
            , {"Svalbard and Jan Mayen", "SJ"}, {"Swaziland", "SZ"}, {"Sweden", "SE"}, {"Switzerland", "CH"}, {"Syrian Arab Republic", "SY"}
            , {"Taiwan, Province of China", "TW"}, {"Tajikistan", "TJ"}, {"Tanzania, United Republic of", "TZ"}, {"Thailand", "TH"}
            , {"Timor-Leste", "TL"}, {"Togo", "TG"}, {"Tokelau", "TK"}, {"Tonga", "TG"}, {"Trinidad and Tobago", "TT"}, {"Tunisia", "TN"}, {"Turkey", "TR"}
            , {"Turkmenistan", "TM"}, {"Turks and Caicos Islands", "TC"}, {"Tuvalu", "TV"}, {"Uganda", "UG"}, {"Ukraine", "UA"}, {"United Arab Emirates", "AE"}
            , {"United Kingdom", "GB"}, {"United States", "US"}, {"United States Minor Outlying Islands", "UM"}, {"Uruguay", "UY"}, {"Uzbekistan", "UZ"}
            , {"Vanuatu", "VU"}, {"Venezuela", "VE"}, {"Viet Nam", "VN"}, {"Virgin Islands, British", "VG"}, {"Virgin Islands, U.S.", "VI"}
            , {"Wallis and Futuna", "WF"}, {"Western Sahara", "EH"}, {"Yemen", "YE"}, {"Zambia", "ZM"}, {"Zimbabwe", "ZW"}

    };
    public static String[][] CURRENCY = {
            {"USD", "USD (United States dollar)"}, {"GBP", "GBP (Great British Pound)"}, {"EUR", "EUR (European Union euro)"}
            , {"ARS", "ARS (Argentine peso)"}, {"AUD", "AUD (Australian dollar)"}, {"BOB", "BOB (Bolivian boliviano)"}
            , {"BRL", "BRL (Brazilian real)"}, {"BGN", "BGN (Bulgarian lev)"}, {"CAD", "CAD (Canadian dollar)"}
            , {"COP", "COP (Colombian peso)"}, {"DKK", "DKK (Danish krone)"}, {"EGP", "EGP (Egyptian pound)"}
            , {"ETB", "ETB (Ethiopian birr)"}, {"HKD", "HKD (Hong Kong dollar)"}, {"INR", "INR (Indian rupee)"}
            , {"IDR", "IDR (Indonesian rupiah)"}, {"JPY", "JPY (Japanese yen)"}, {"KZT", "KZT (Kazakhstan tenge)"}
            , {"MYR", "MYR (Malaysian ringgit)"}, {"MXN", "MXN (Mexican peso)"}, {"MAD", "MAD (Moroccan dirham)"}
            , {"ILS", "ILS (New Israeli shekel)"}, {"TWD", "TWD (New Taiwan dollar)"}, {"TRY", "TRY (New Turkish lira)"}
            , {"NZD", "NZD (New Zealand dollar)"}, {"NGN", "NGN (Nigerian naira)"}, {"NOK", "NOK (Norwegian krone)"}
            , {"PKR", "PKR (Pakistani rupee)"}, {"PEN", "PEN (Peruvian nuevo sol)"}, {"PHP", "PHP (Philippine peso)"}
            , {"PLN", "PLN (Polish zloty)"}, {"QAR", "QAR (Qatari rial)"}, {"RUB", "RUB (Russian ruble)"}
            , {"SAR", "SAR (Saudi Arabian riyal)"}, {"SGD", "SGD (Singapore dollar)"}, {"ZAR", "ZAR (South African rand)"}
            , {"KRW", "KRW (South Korean won)"}, {"SEK", "SEK (Swedish krona)"}, {"CHF", "CHF (Swiss franc)"}
            , {"TZS", "TZS (Tanzanian shilling)"}, {"THB", "THB (Thai baht)"}, {"UAH", "UAH (Ukrainian hryvnia)"}
            , {"AED", "AED (United Arab Emirates dirham)"}, {"VND", "VND (Viet Nam dong)"}, {"CNY", "CNY (Yuan renminbi)"}
    };

    public static String listCompare[] = {
            "Zinio Newsstand Test", "Zinio Staff Registration", "Samsung Newsstand Manager", "Relay Newsstand Manager", "Zinio Admin",
            "Zinio Newsstand Manager Instance", "Zinio Unlimited Newsstand Manage", "Sanoma Admin", "Zinio Console/CMS Platforms"};

    public enum PAGE {
        ACCOUNTS("Accounts"),
        PROJECTS("Projects"),
        NEWSSTANDS("Newsstands"),
        CATALOGS("Catalogs"),
        CATEGORY_SETS("Category Sets"),
        PUBLISHERS("Publishers"),
        PUBLICATIONS("Publications"),
        USERS("Users"),
        ORDERS("Orders"),
        CAMPAIGNS("Campaigns"),
        BANNERS("Banners"),
        APPLICATIONS("Applications"),
        DIRECTORIES("Directories"),
        ISSUES("Issues");

        private String pageName;

        PAGE(String pageName) {
            this.pageName = pageName;
        }

        public String pageName() {
            return pageName;
        }
    }

    public enum FILTER {
        CATALOG_STATUS("Catalog Status"),
        CONTENT_RATING("Content Rating"),
        TYPE("Type");

        private String value;

        FILTER(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    public enum OPTION {all,any,many}
    public static String AUTHENTICATE_API_URL = "https://stg-admin-backend.zinio.com/v1/identity/authentication";

    public static String dataFileLink = "/src/test/java/testData/Data.properties";
}
