package com.zinio.zenith.converter;

import cucumber.deps.com.thoughtworks.xstream.converters.basic.IntConverter;

/**
 * Created by ducnguyen on 9/15/16.
 */
public class NullableIntConverter extends IntConverter implements NullableConverter {
    public Object fromString(String str) {
        return NullableConverter.super.fromString(str);
    }

    @Override
    public Object convertFromString(String str) {
        return super.fromString(str);
    }
}
