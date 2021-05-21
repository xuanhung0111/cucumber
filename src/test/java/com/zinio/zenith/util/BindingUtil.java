package com.zinio.zenith.util;

/**
 * Created by trongnguyen on 9/21/16.
 */
public class BindingUtil {
    public static String dynamicFormatData(Object value) {
        if (null == value) {
            return " is null";
        } else {
            if(value instanceof Number) {
                return "=" + value.toString();
            } else {
                try {
                    double d = Double.parseDouble(value.toString());
                    return "=" + value.toString();
                } catch (NumberFormatException nfe) {
                    return "='" + value.toString() + "'";
                }
            }
        }
    }

}
