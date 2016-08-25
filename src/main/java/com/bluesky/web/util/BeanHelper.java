package com.bluesky.web.util;

import com.bluesky.web.helper.ClassHelper;
import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 55 on 2016/8/25.
 */
public class BeanHelper {

    /**
     * 定义Bean映射（用于存放Bean）
     */
    private static final Map<Class<?>,Object> BEAN_MAP = new HashMap<Class<?>,Object>();

    static{
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for(Class<?> beanClass : beanClassSet){
            Object object = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass , object);
        }
    }


}
