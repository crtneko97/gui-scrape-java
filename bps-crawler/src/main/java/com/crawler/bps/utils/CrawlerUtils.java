package com.crawler.bps.utils;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlerUtils {

    // Check if a string is a valid URL
    public static boolean isValidUrl(String url) {
        String regex = "^(https?|ftp)://[^\s/$.?#].[^\s]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    // Check if the file name is valid
    public static boolean isValidFileName(String fileName) {
        return fileName.matches("^[a-zA-Z0-9._-]+$");
    }

    // Extract the domain from a URL
    public static String getDomain(String url) {
        try {
            URL urlObj = new URL(url);
            return urlObj.getHost();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
