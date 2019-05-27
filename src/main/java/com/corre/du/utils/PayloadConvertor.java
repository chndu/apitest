package com.corre.du.utils;


import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.corre.du.base.RESTCalls;

public class PayloadConvertor {

    private  static Logger log = Logger.getLogger(PayloadConvertor.class.getName());

    public static String generatePayloadString(String fileName){
        log.info("Inside payload fucntion");
        String filePath = System.getProperty("user.dir")+"\\data\\"+fileName;
        String file1 = System.getProperty("user.dir");
        System.out.println(file1);
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        }catch (Exception e){
            log.error(e);
            return null;
        }
    }
}
