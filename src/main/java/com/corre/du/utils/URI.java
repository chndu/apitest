package com.corre.du.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class URI {

    private static Logger log = LogManager.getLogger(URI.class.getName());


    public static final String URI = "http://bigdata.stargraph.cn";

    public static String getEndPoint(){
        log.info("base ui"+ URI);
        return URI;
    }

    public static String getEndPoint(String resources){
        log.info("endpoint"+ URI + resources);

        return URI + resources;
    }
}
