package com.corre.du.base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTCalls {
    private static Logger log = LogManager.getLogger(RESTCalls.class.getName());

    public static Response GETrequest(String URI,String sessionId){
        log.info("Inside GETRequest call");
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Cookie","access_token=" + sessionId + "");
        Response response = requestSpecification.get(URI);
        log.debug(requestSpecification.log().all());
        return response;
    }


    public static Response POSTrequest(String URI,String strJSON){
        log.info("Inside POSTRequest call");
        RequestSpecification requestSpecification = RestAssured.given()
                .body(strJSON);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.post(URI);
        log.debug(requestSpecification.log().all());
        return  response;
    }


    public static Response POSTrequest(String URI,String strJSON,String sessionId){
        log.info("Inside POSTRequest call");
        RequestSpecification requestSpecification = RestAssured.given()
                .body(strJSON);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Cookie","access_token=" + sessionId + "");
        Response response = requestSpecification.post(URI);
        log.debug(requestSpecification.log().all());
        return  response;
    }

    public  static Response PUTrequest(String URI,String strJSON){
        log.info("inside PUTrequest call");
        RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.put(URI);
        log.debug(requestSpecification.log().all());
        return response;
    }

    public static Response DELETErequest(String URI, String strJSON){
        log.info("Inside DELETErequest call");
        RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.delete(URI);
        log.debug(requestSpecification.log().all());
        return response;
    }
}
