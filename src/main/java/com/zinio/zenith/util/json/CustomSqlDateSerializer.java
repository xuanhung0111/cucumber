package com.zinio.zenith.util.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import com.zinio.zenith.util.Constants;
/**
 * Created by ducnguyen on 9/19/16.
 */
public class CustomSqlDateSerializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        String dateString = p.getText().trim();
        if (dateString.length() > 20) {
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateString);
            return Date.valueOf(zonedDateTime.toLocalDate());
        }
        return Date.valueOf(LocalDate.parse(dateString, Constants.DATE_TIME_FORMATTER));
    }

}

