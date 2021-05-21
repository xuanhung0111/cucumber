package com.zinio.zenith.converter;

import cucumber.deps.com.thoughtworks.xstream.converters.extended.SqlDateConverter;

import java.sql.Date;
import java.time.*;
import java.util.Locale;

import com.zinio.zenith.util.Constants;

/**
 * Created by ducnguyen on 9/18/16.
 */
public class NullableSqlDateConverter extends SqlDateConverter implements NullableConverter {

    public Object fromString(String str) {
        return NullableConverter.super.fromString(str);
    }

    @Override
    public Object convertFromString(String str) {
//        return super.fromString(str);
        LocalDate localDate = LocalDate.parse(str, Constants.DATE_TIME_FORMATTER);
        return Date.valueOf(localDate);
//        LocalDateTime localDateTime = LocalDateTime.of(localDate, Constants.START_OF_DAY);
//        ZonedDateTime zonedDateTime = ZonedDateTime.ofLocal(localDateTime, Constants.SYSTEM_ZONE, Constants.SYSTEM_OFFSET);
//        return Date.valueOf(zonedDateTime.toLocalDate());
    }

}
