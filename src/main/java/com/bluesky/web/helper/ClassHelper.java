package com.bluesky.web.helper;

import com.bluesky.web.annotation.Controller;
import com.bluesky.web.annotation.Inject;
import com.bluesky.web.annotation.Service;
import com.bluesky.web.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 类助手
 * Created by hadoop on 2016/8/23.
 */
public final class ClassHelper {
    //定义类集合存放所有所加载的类
    private static final Set<Class<?>> CLASS_SET;

    static{
        String basePackage = ConfigHelper.getBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包下的所有类
     * @return
     */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    /**
         * 获取应用包下的所有Service
         */
        public static Set<Class<?>> getServiceClassSet(){
            Set<Class<?>> classSet = new HashSet<Class<?>>();
            for(Class<?> cls : CLASS_SET){
                if(cls.isAnnotationPresent(Service.class)){
                    classSet.add(cls);
                }
            }
            return classSet;
    }

    /**
     * 获取应用包下的所有Controller
     */
    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET){
            if(cls.isAnnotationPresent(Controller.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包下的所有Inject
     */
    public static Set<Class<?>> getInjectClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET){
            if(cls.isAnnotationPresent(Inject.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包下的所有bean类（包括Service、controller类）
     * @return
     */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }
}
