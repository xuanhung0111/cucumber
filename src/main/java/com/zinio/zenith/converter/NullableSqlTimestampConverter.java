package com.zinio.zenith.converter;

import com.zinio.zenith.util.Constants;
import cucumber.deps.com.thoughtworks.xstream.converters.extended.SqlTimestampConverter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by ducnguyen on 9/18/16.
 */
public class NullableSqlTimestampConverter extends SqlTimestampConverter implements NullableConverter {
    public Object fromString(String str) {
        return NullableConverter.super.fromString(str);
    }


    public Object convertFromString(String str) {
        String dateString = str.trim();
        if (dateString.length() > 20) {
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateString, Constants.DATE_TIME_UTC_FORMATTER);
            return Timestamp.valueOf(zonedDateTime.toLocalDateTime().plus(Constants.OFFSET_IN_MILLI, ChronoUnit.MILLIS));
        }
        return Timestamp.valueOf(LocalDateTime.parse(dateString, Constants.DATE_TIME_FORMATTER).plus(Constants.OFFSET_IN_MILLI, ChronoUnit.MILLIS));
    }

}
