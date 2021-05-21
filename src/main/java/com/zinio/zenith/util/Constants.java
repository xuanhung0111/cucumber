package com.zinio.zenith.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by trongnguyen on 9/20/16.
 */
public interface Constants {
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter DATE_TIME_UTC_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
    long OFFSET_IN_MILLI = TimeZone.getDefault().getOffset(new Date().getTime());
    //    LocalTime START_OF_DAY = LocalTime.of(0, 0, 0);
    ZoneId SYSTEM_ZONE = ZoneId.systemDefault();
//    ZoneOffset SYSTEM_OFFSET = LocalDateTime.now().atZone(SYSTEM_ZONE).getOffset();

    byte DISTRIBUITION_CHANNEL_ITC = 1;
    byte DISTRIBUITION_CHANNEL_GOOLE_PLAY = 2;
    byte DISTRIBUITION_CHANNEL_SAMSUNG = 3;
    byte DISTRIBUITION_CHANNEL_BRAINTREE = 4;
    byte DISTRIBUITION_CHANNEL_RELAY = 5;

    Byte ISSUE_TYPE_ANY = null;
    Byte ISSUE_TYPE_STANDARD = 0;
    Byte TYPE_STANDALONE = 1;
    Byte TYPE_SPECIAL = 2;


}
