package com.corre.du.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
public class GetFileMess {

    private static Properties properties;
    Logger log = Logger.getLogger(GetFileMess.class);


    /**
     * 根据properties文件主键获取对应值
     */

    public String getValue(String key,String propertiesFileName) throws IOException{
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("\\"+propertiesFileName);
        properties = new Properties();
        properties.load(stream);
        String value = properties.getProperty(key);
        return value;
    }
}
