package com.corre.du.utils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestUtils {

    private static Logger log = LogManager.getLogger(TestUtils.class.getName());

    public static String getReponseString(io.restassured.response.Response response){
        log.info("Converting response to string");
        String strResponse = response.getBody().asString();
        log.debug(strResponse);
        return strResponse;
    }

    public static JsonPath jsonParser(String response){
        log.info("Parsing String response to json");
        JsonPath jsonResponse = new JsonPath(response);
        log.debug(jsonResponse);
        return jsonResponse;
    }


    public static  int getStatusCode(io.restassured.response.Response response){
        log.info("Get status code");
        int statusCode = response.getStatusCode();
        log.debug(statusCode);
        return statusCode;
    }

    public static String getStatusMessage(io.restassured.response.Response response){
        log.info("Fet status message");
        String message = response.getStatusLine();
        log.debug(message);
        return message;
    }
}
