package com.df4j.xcwork.base.utils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class BeanUtils {

    /**
     * 设置属性
     *
     * @param target
     * @param fieldName
     * @param value
     */
    public static void setProperty(Object target, String fieldName, Object value) {
        if (target == null) {
            return;
        }
        Class c = target.getClass();
        Field field = ReflectionUtils.findField(c, fieldName);
        if (field == null) {
            return;
        }
        field.setAccessible(true);
        ReflectionUtils.setField(field, target, value);
    }
}
