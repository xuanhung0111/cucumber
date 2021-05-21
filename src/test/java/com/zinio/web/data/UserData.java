package com.zinio.web.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserData {
		// User name and password login
		public static final String USER_NAME = "xuanhung.nguyen"; 
		public static final String USER_EMAIL= "xuanhung.nguyen@zinio.com"; 
		public static final String PASSWORD = "Xu@nhu0ng";
		
		// Credit Card
		
		public static final String FIRST_NAME = "Hung";
		public static final String LAST_NAME = "Nguyen";
		public static final String CART_NUMBER = "4111111111111111";
		public static final String CART_NUMBER_FORMAT = "xxxx-xxxx-xxxx-1111";
		public static final String CART_NUMBER_UPDATE_FORMAT = "xxxx-xxxx-xxxx-4444";
		public static final String CVV = "123";
		public static final String EXPIRE_DATE = "12/2030";
		public static final String EXPIRE_DATE_UPDATE = "8/2031";
		public static final String EXPIRE_DATE_SORT = "12/30";
		public static final String CARD_PROVIDER = "Visa";
		DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
		Date date = new Date();
		public String currentDate= dateFormat.format(date); 

		// Billing information
		
		public static final  String ADDRESS = "Fleimington";
		public static final  String CITY = "HCM";
		public static final  String ZIPCODE = "456";
		public static final  String COUNTRY = "Viet Nam";
		public static final  String COUNTRY_KEY = "VN";
		
		// Paypal account
		public static final String USER_PAYPAL = "xuanhung.nguyen-buyers@zinio.com";
		public static final String PASSWORD_PAYPAL = "Xu@nhu0ng";
		
		// Reader
		public static String[] TABLE_CONTENT_LIST = {"In This Issue", "Also in This Issue", "On the Cover"};
		public static String BOOKMARK_DESCRIPTION = "This is bookmark description";
		public static String BOOKMARK_SPECIAL_DESCRIPTION = "{[}[;:'?/|\\><.,'`~!@#$%^&*()_-+=";
		public static String[] NEW_CREDIT_CARD_INFO = {"Hai", "Ha", "5555555555554444", "12/2020", "123", "1 Thanh Thai", "Saigon", "12343", "AL"};
		
}
