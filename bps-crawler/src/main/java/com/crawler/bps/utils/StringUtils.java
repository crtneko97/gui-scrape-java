package com.crawler.bps.utils;

public class StringUtils {

    // Trim leading and trailing spaces from a string
    public static String trim(String str) {
        return str != null ? str.trim() : null;
    }

    // Split a string by a delimiter and return the parts as an array
    public static String[] split(String str, String delimiter) {
        return str != null ? str.split(delimiter) : new String[0];
    }

    // Convert a string to lowercase
    public static String toLowerCase(String str) {
        return str != null ? str.toLowerCase() : null;
    }
}
