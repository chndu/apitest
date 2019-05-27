package com.corre.du.base;

import com.corre.du.utils.TestUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;



import io.restassured.response.Response;
public class Assertions {

    private static Logger log = LogManager.getLogger(Assertions.class.getName());

    public  static void verifyTrue(boolean flag){
        Assert.assertTrue(flag);
    }

    public static void verifyFalse(boolean flag){
        Assert.assertFalse(false);
    }

    public static  void verifyStatusCode(Response response,int status){
        Assert.assertEquals(TestUtils.getStatusCode(response),status);
    }

    public  static void verifyStatusMessage(Response response,int status){
        Assert.assertEquals(TestUtils.getStatusMessage(response),status);
    }
}
