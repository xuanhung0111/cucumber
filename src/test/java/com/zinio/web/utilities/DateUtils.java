package com.zinio.web.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String getCurrentDateTime(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    public static String getDate(String convertDate, String format, int deltaDay) {
        Date date = new Date();
        if(convertDate != "") {
            DateFormat df = new SimpleDateFormat(format);
            try {
                date = df.parse(convertDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, deltaDay);
        Date result = cal.getTime();
        return new SimpleDateFormat(format).format(result);
    }
}
