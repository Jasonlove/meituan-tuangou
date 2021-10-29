package com.meituan.tuangou.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * json工具类
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = null;
    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyyMMddHHmmssS"));
    }

    /**
     * json串转为Java对象列表。
     * @param json json串
     * @param clazz Java类
     * @return Java对象列表
     * @throws Exception
     */
    public static <T> List<T> toJavaList(String json, Class<T> clazz) throws Exception {
        return objectMapper.readValue(json, objectMapper.getTypeFactory()
                .constructCollectionType(List.class, clazz));
    }

    /**
     * 从文件中读取json串，并转为Java对象列表。
     * @param file 文件
     * @param clazz Java类
     * @return Java对象列表
     * @throws Exception
     */
    public static <T> List<T> toJavaList(File file, Class<T> clazz) throws Exception {
        return objectMapper.readValue(file, objectMapper.getTypeFactory()
                .constructCollectionType(List.class, clazz));
    }

    /**
     * json串转为Java对象。
     * @param json json串
     * @param clazz Java类
     * @return Java对象
     * @throws Exception
     */
    public static <T> T toJava(String json, Class<T> clazz) throws Exception {
        return objectMapper.readValue(json, clazz);
    }

    public static <T, V> Map<T, V> toJavaMap(String jsonString, Class<T> keyClass, Class<V> valueClass) throws Exception {
        return objectMapper.readValue(jsonString, objectMapper.getTypeFactory()
                .constructMapLikeType(Map.class, keyClass, valueClass));
    }

    /**
     * 对象转为Map<String, Object>
     *
     * @param
     * @return
     */
    public static Map<String, Object> toMap(Object object) {
        return objectMapper.convertValue(object,
                new TypeReference<Map<String, Object>>() {
                });

    }

    /**
     * Java对象转为json串。
     * @param obj Java对象
     * @return json串
     * @throws Exception
     */
    public static String toJsonString(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }


    /**
     * Java对象转为json串。
     * @param obj Java对象
     * @return json串
     */
    public static String jsonString(Object obj){
        try {
            return objectMapper.writeValueAsString(obj);
        }catch (Exception e){
            return StringUtils.EMPTY;
        }
    }
}
