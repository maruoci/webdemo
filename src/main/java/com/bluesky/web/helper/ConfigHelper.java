package com.bluesky.web.helper;

import com.bluesky.web.constants.ConfigConstant;
import com.bluesky.web.util.PropsUtils;

import java.util.Properties;

/**
 * 配置文件助手类
 * Created by hadoop on 2016/8/23.
 */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtils.loadProps(ConfigConstant.CONFIG_FILE);

    public static String getJdbcDriver(){
        return PropsUtils.getString(CONFIG_PROPS , ConfigConstant.JDBC_DRIVER);
    }

    public static String getJdbcUrl(){
        return PropsUtils.getString(CONFIG_PROPS , ConfigConstant.JDBC_URL);
    }

    public static String getJdbcUsername(){
        return PropsUtils.getString(CONFIG_PROPS , ConfigConstant.JDBC_USERNAME);
    }

    public static String getJdbcPassword(){
        return PropsUtils.getString(CONFIG_PROPS , ConfigConstant.JDBC_PASSWORD);
    }

    public static String getBasePackage(){
        return PropsUtils.getString(CONFIG_PROPS , ConfigConstant.BASE_PACKAGE);
    }

    public static String getJspPath(){
        return PropsUtils.getString(CONFIG_PROPS , ConfigConstant.JSP_PATH , "/WEB-INF/view/");
    }

    public static String getAssetPath(){
        return PropsUtils.getString(CONFIG_PROPS , ConfigConstant.ASSET_PATH , "/asset/");
    }
}
