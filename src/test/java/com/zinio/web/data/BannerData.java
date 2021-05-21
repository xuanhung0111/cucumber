package com.zinio.web.data;

import com.zinio.web.utilities.StringUtils;

/**
 * Created by khanhle on 9/11/17.
 */
public class BannerData {
    public static String[] ACTION = {"article", "articles", "category", "issue", "issues", "open_external_url", "publication",
            "publications", "view_article", "view_articles", "view_campaign", "view_category", "view_issue", "view_issues",
            "view_publication", "view_publications", "view_list", "view_list_articles", "view_list_categories", "view_list_issue",
            "view_list_issues", "view_list_publications","view_story"};
    public static String[] TYPE = {"Static", "Campaign Related", "User Specific"};
    public static String[] STATUS = {"Disabled", "Enabled"};
    public static String[][] URLIMAGE2x1 = {
            {"png", "https://wallpaperhdzone.com/wp-content/uploads/2016/02/warrior-cats-wallpaper-5.png"},
            {"jpg", "https://s-media-cache-ak0.pinimg.com/originals/53/9e/6e/539e6e5b9026923a813cf2c1ff6c6b74.jpg"},
            {"jpeg", "http://www.atozpictures.com/admin/uploads/2017/05/cheetah-animal-desktop-photos.jpeg"}
    };
    public static String[][] URLIMAGE4x1 = {
            {"jpg", "http://souloftruth.com/wp-content/uploads/2014/05/cropped-footprints-in-the-sand-beach-hd-wallpaper-17555.jpg"},
            {"png", "http://cdn.wallpapersafari.com/56/78/qJ62xc.png"},
            {"jpeg", "https://cdn-images-1.medium.com/max/1600/1*qPBN5q5ZOWGD-wej-gpFfw.jpeg"},
            {"gif", "http://img36.laughinggif.com/pic/HTTP2luZm8udGhvdWdodHdvcmtzLmNvbS9ycy8xOTktUURFLTI5MS9pbWFnZXMvR3JhZHVhdGUtQW5pbWF0ZWQtQmFubmVyLjEuZ2lm.gif"}
    };
    public static String IMAGE_TYPE_NOT_SUPPORT = "http://www.nightprogrammer.org/wp-uploads/2013/02/multipage_tif_example.tif";
    public static String[][] URLIMAGE3x1 = {
            {"jpg", "http://www.advaitlabs.in/images/science-hd-wallpaper-optimized.jpg"},
            {"png", "https://pbs.twimg.com/media/CvD5cmUVMAEbchf.png"},
            {"jpeg", "http://jimswallpaperandpainting.com/_Media/img_4154_hr.jpeg"},
            {"jpeg", "https://www.turtlebeachresort.com/images/made/chrootimages/uploads/top-photos/dog-in-beach-watch-sunset-wallpaper-hd-dekstop_1200_400_s_c1_c_c.jpeg"}
    };

    public static String[] PLATFORM = {"iOS","Android","Web"};

    public static String IMAGE_URL = "http://www.mytinyphone.com/uploads/users/twifranny/560841.jpg";


    public static String[] BANNER_TYPE_FILTER = StringUtils.addStringToArray(TYPE, "Choose Type");
    public static String[] BANNER_STATUS_FILTER = StringUtils.addStringToArray(STATUS, "Choose Status");
    public static String[] BANNER_ACTION_FILTER = StringUtils.addStringToArray(ACTION, "Choose action");

    public static String[] BANNER_REQUIRED_FIELD = {"Title", "Type", "Status"};
    public static String TITLE_REQUIRED_MESSAGE = "Title cannot be empty.";
    public static String TYPE_REQUIRED_MESSAGE = "Type cannot be empty.";
    public static String STATUS_REQUIRED_MESSAGE = "Status cannot be empty.";


    public static String[] DEFAULT_COLUMNS = {"Preview", "Title", "ID", "Type", "Status", "Platform"};
    public static String[] BANNER_ALL_COLUMNS = {"Preview", "Title", "Subtitle", "ID"
            , "Type", "Status", "Created At", "Modified At"};
    public static String[] BANNER_REMOVE_COLUMNS = {"Title", "ID"};

    public static String[] DEFAULT_COLUMNS_IN_CAMPAIGN_MANAGE = {"Preview", "Title", "ID","Platform"};
    public static String[] DEFAULT_COLUMNS_IN_NEWSSTAND_MANAGE = {"Preview", "Title", "ID","Platform","Campaign " +
            "Code","Type"};
    public static String[] DEFAULT_COLUMNS_IN_ASSIGNED_LIST = {"Preview", "Title", "ID","Platform","Status"};

    public static String[] STATUS_ASSIGNED_COMPAIGNS = {"Draft", "Active"};
    public static String[] STATUS_UNASSIGNED_COMPAIGNS = {"Archived", "Inactive"};

    public static String FOLDER_IMAGE_FILE = "/src/test/java/testData/image";
    public static String FOLDER_INVALID_FILE = "/src/test/java/testData/invalidfile";
    public static String FOLDER_IMAGE_OVERSIZE = "/src/test/java/testData/oversizeImage";
    public static int NUMBER_TARGET_REQUEST_PARAMETERS = 10;
    public static String[] BANNER_GROUP_LANGUAGE = {"English","Spanish","German","French","Single Language"};
    public static String BANNER_ALL_NEWSSTANDS = "All Newsstands";
    public static String[] BANNER_SWITCH_OPTIONS = {"Newsstand", "Campaign"};
}
