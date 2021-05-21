package com.zinio.zenith.util.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.zinio.zenith.util.Constants;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;

/**
 * Created by ducnguyen on 9/19/16.
 */
public class CustomSqlTimestampSerializer extends JsonDeserializer<Timestamp> {

    @Override
    public Timestamp deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        String dateString = p.getText().trim();
        if (dateString.length() > 20) {
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateString, Constants.DATE_TIME_UTC_FORMATTER);
            return Timestamp.valueOf(zonedDateTime.toLocalDateTime().plus(Constants.OFFSET_IN_MILLI, ChronoUnit.MILLIS));
        }
        return Timestamp.valueOf(LocalDateTime.parse(dateString, Constants.DATE_TIME_FORMATTER).plus(Constants.OFFSET_IN_MILLI, ChronoUnit.MILLIS));
    }

}

