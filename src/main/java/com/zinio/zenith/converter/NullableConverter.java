package com.zinio.zenith.converter;

import cucumber.deps.com.thoughtworks.xstream.converters.ConverterMatcher;

/**
 * Created by ducnguyen on 9/18/16.
 */
public interface NullableConverter extends ConverterMatcher {
    String NULL_CONST = "NULL";

    default Object fromString(String str) {
        if (NULL_CONST.equals(str)) {
            return null;
        } else {
            return convertFromString(str);
        }
    }

    Object convertFromString(String str);
}
