package com.kl.advocatesystem.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtils {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static Object fromJson(String json, Class<?> clazz) {
        try {
            return new ObjectMapper().readValue(json, clazz);
        } catch (Exception e) {
            logger.error("Error deserializing JSON using Jackson.", e);

            Gson gson = new GsonBuilder().serializeNulls().create();
            return gson.fromJson(json, clazz);
        }
    }
}
