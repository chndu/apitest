import com.corre.du.base.Base;
import com.corre.du.base.RESTCalls;
import com.corre.du.utils.PayloadConvertor;
import com.corre.du.utils.URI;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.http.Cookie;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.transform.OutputKeys;

import static com.corre.du.base.Assertions.verifyStatusCode;
import static com.corre.du.base.Assertions.verifyStatusMessage;
import static org.apache.log4j.varia.ExternallyRolledFileAppender.OK;

public class queryCompanyDetailTest {

    private String sessionId;
        Response response;
        String msg = OK;
        @BeforeMethod
        public void setUp(){
            sessionId = Base.doLogin();
        }

        @Test(priority = 1)
        @Feature("登录")
        public void queryCompanyDetailTest(){
            String URL = URI.getEndPoint("/api/proxy/crawl/query_status?company=%E6%B5%99%E6%B1%9F%E7%BB%BF%E5%9C%B0%E8%83%BD%E6%BA%90%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8");
            response = RESTCalls.GETrequest(URL,sessionId);
            System.out.println(response.getBody());
            String strResponse = response.getBody().asString();
            JsonPath jsonPath = new JsonPath(strResponse);
            verifyStatusCode(response,200);
    }

        @Test(priority = 2)
        public void queryExchangeRate(){
            String URL = URI.getEndPoint("/api/search/exchange_rate_map");
            response = RESTCalls.GETrequest(URL,sessionId);
            response.getBody().prettyPrint();
            String strResponse = response.getBody().asString();
            JsonPath jsonPath = new JsonPath(strResponse);
          System.out.println(jsonPath);
        }


        @Test(priority = 3)
        public void getMes(){
            String getMes = PayloadConvertor.generatePayloadString("getMes.json");
            String URL =  URI.getEndPoint("/api/notification/getMsgs");
            response = RESTCalls.POSTrequest(URL,getMes,sessionId);
            response.getBody().prettyPrint();
            String strResponse = response.getBody().asString();
            JsonPath jsonPath = new JsonPath(strResponse);
            verifyStatusCode(response,200);

        }

        @Feature("查看关系")
        @Test
        public void getBriefTest(){
            String URL = URI.getEndPoint("/api/graph/brief?company=%E6%B5%99%E6%B1%9F%E7%BB%BF%E5%9C%B0%E8%83%BD%E6%BA%90%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8");
            response = RESTCalls.GETrequest(URL,sessionId);
            response.getBody().prettyPrint();
            String strResponse = response.getBody().asString();
            JsonPath jsonPath = new JsonPath(strResponse);
            String status = jsonPath.getString("msg");
            Assert.assertEquals(status,msg,"判断响应状态码");
            verifyStatusCode(response,200);

        }



}


