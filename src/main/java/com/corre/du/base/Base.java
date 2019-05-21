package com.corre.du.base;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.corre.du.utils.PayloadConvertor;
import com.corre.du.utils.URI;
import com.corre.du.utils.TestUtils;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static com.corre.du.base.Assertions.verifyStatusCode;

public class Base {

    private static Logger log = LogManager.getLogger(Base.class.getName());

    public static String doLogin(){
        Response response;
        log.info("starting testcase: login");

        String loginPalyload = PayloadConvertor.generatePayloadString("Login.json");
        String endpointURI = URI.getEndPoint("/api/user/login");

        response = RESTCalls.POSTrequest(endpointURI,loginPalyload);

        log.info(response.getBody().asString());

        String strResponse = TestUtils.getReponseString(response);
        JsonPath jsonPath = TestUtils.jsonParser(strResponse);
        String sessionId = jsonPath.getString("access_token");
        System.out.println("系统登录Cookies:" + sessionId);
        return sessionId;

    }


    public static void logout(){
        Response response;
        log.info("stop testcase: logout");

        String endpointURI = URI.getEndPoint("/api/user/logout");

        response = RESTCalls.GETrequest(endpointURI);

        log.info(response.getBody().asString());

        verifyStatusCode(response,200);
    }
}
