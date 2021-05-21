package com.zinio.web.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyUtils {
    public static String getPropAsString(String property) {
        try {
            Properties prop = new Properties();
            FileInputStream inputStream = new FileInputStream("config.properties");
            prop.load(inputStream);
            inputStream.close();
            return prop.getProperty(property);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static int getPropAsInt(String property) {
        return Integer.parseInt(getPropAsString(property));
    }

    public static boolean getPropAsBool(String property) {
        return Boolean.parseBoolean(getPropAsString(property));
    }

    public static void setProperty(String property, String value) {
        try {
            Properties prop = new Properties();
            FileInputStream inputStream = new FileInputStream("config.properties");
            prop.load(inputStream);
            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream("config.properties");
            prop.setProperty(property, value);
            prop.store(outputStream, null);
            outputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getPropAsStringFromFile(String filename, String property) {
        String dir = System.getProperty("user.dir");
        filename = dir + filename;
        try {
            Properties prop = new Properties();
            FileInputStream inputStream = new FileInputStream(filename);
            prop.load(inputStream);
            inputStream.close();
            return prop.getProperty(property);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}