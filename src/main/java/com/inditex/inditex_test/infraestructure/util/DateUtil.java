package com.inditex.inditex_test.infraestructure.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateUtil {

    private static final String FORMAT = "yyyy-MM-dd-HH.mm.ss";

    public static Timestamp stringToTimestamp(final String strDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
            Date date = dateFormat.parse(strDate);
            return new Timestamp(date.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static String timestampToString(final Timestamp timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
        return dateFormat.format(timestamp);

    }
}
