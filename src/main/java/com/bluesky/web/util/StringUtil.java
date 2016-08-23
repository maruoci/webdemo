package com.bluesky.web.util;
import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 */
public final class StringUtil{
    /**
     * 空判断
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str != null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 非空判断
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}