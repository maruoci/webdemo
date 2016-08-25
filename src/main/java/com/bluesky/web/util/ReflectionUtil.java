package com.bluesky.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射工具类
 * Created by hadoop on 2016/8/23.
 */
public final class ReflectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger("LOG_INFO");

    public static Object newInstance(Class<?> cls){
        Object instance;
        try{
            instance = cls.newInstance();
        }catch (Exception e){
            LOGGER.error("new instance failure" , e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 调用方法
     * @param object
     * @param method
     * @param args
     * @return
     */
    public static Object invokeMethod(Object object , Method method , Object... args){
        Object result;
        try{
            method.setAccessible(true);
            result = method.invoke(object,args);
        }catch (Exception e){
            LOGGER.error("invoke method failure" , e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 设置成员变量的值
     * @param object
     * @param field
     * @param value
     */
    public static void setField(Object object , Field field , Object value){
        try{
            field.setAccessible(true);
            field.set(object , value);
        }catch (Exception e){
            LOGGER.error("set field failure " , e);
            throw new RuntimeException(e);
        }
    }


}
