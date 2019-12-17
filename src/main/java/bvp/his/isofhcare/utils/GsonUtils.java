/*
 * *******************************************************************
 * Copyright (c) 2018 Isofh.com to present.
 * All rights reserved.
 *
 * Author: tuanld
 * ******************************************************************
 *
 */

package bvp.his.isofhcare.utils;

import bvp.his.isofhcare.annotation.AnnotationExclusionStrategy;
import bvp.his.isofhcare.constant.AppConst;
import bvp.his.isofhcare.convertor.LocalDateJsonConverter;
import bvp.his.isofhcare.convertor.LocalDateTimeJsonConverter;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GsonUtils {

    /**
     * Convert String to Object
     *
     * @param json
     * @param cls
     * @return
     */
    public static <T> T toObject(String json, Class<T> cls) {
        return new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeJsonConverter())
            .registerTypeAdapter(LocalDate.class, new LocalDateJsonConverter())
            .create().fromJson(json, cls);
    }

    /**
     * Convert String to Object
     *
     * @param json
     * @param cls
     * @return
     */
    public static <T> T toObject(JsonElement json, Class<T> cls) {
        return new GsonBuilder().setDateFormat(AppConst.DATE_TIME_FORMAT).registerTypeAdapter(LocalDateTime.class, new LocalDateTimeJsonConverter()).create().fromJson(json, cls);
    }

//    /**
//     * Convert Object to String using Json
//     *
//     * @param obj
//     * @return
//     */
//    public static String toStringResult(Object obj) {
//        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create().toJson(obj);
//    }

    /**
     * Convert Object to String using Json
     *
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        return new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeJsonConverter())
            .setPrettyPrinting()
            .setExclusionStrategies(new AnnotationExclusionStrategy())
            .create()
            .toJson(obj);
    }

    public static String toStringCompact(Object obj) {
        return new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeJsonConverter())
            .setPrettyPrinting()
            .setExclusionStrategies(new AnnotationExclusionStrategy())
            .create()
            .toJson(obj);
    }

}
