package com.crawler.bps.utils;

import com.google.gson.Gson;

public class JsonUtils {

    private static final Gson gson = new Gson();

    // Convert an object to a JSON string
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    // Convert a JSON string to an object
    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }
}
