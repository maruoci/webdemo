package com.bluesky.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件工具类
 * Created by 55 on 2016/8/22.
 */
public class PropsUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger("LOG_INFO");

    public static Properties loadProps(String fileName){
        Properties props = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is == null){
                throw new FileNotFoundException(fileName + " file is not found!");
            }
            props = new Properties();
            props.load(is);
        }catch (Exception e){
            LOGGER.info("load properties failure!" , e);
        }finally {
            if(is !=null){
                try{
                    is.close();
                }catch (IOException e){
                    LOGGER.info("close input stream failure" , e);
                }
            }
        }
        return props;
    }


}
