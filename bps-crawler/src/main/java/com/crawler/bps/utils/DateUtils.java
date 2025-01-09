package com.crawler.bps.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    // Format the current date as a string
    public static String getCurrentDateString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }

    // Convert a Date object to a formatted string
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }
}
