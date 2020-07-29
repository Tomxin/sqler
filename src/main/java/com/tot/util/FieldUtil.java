package com.tot.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class FieldUtil {
    public static Set<String> getFiledName(Object o) {
        Class<?> clazz = o.getClass();
        Set<String> fieldSet = new HashSet<>();
        while (!clazz.equals(Object.class)) {
            for (Field field : clazz.getDeclaredFields()) {
                fieldSet.add(field.getName());
            }
            clazz = clazz.getSuperclass();
        }

        return fieldSet;
    }

    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter);
            return method.invoke(o);
        } catch (Exception e) {
            throw new IllegalStateException(String.format("属性【%s】不存在", fieldName));
        }
    }
}
