import com.corre.du.base.Base;
import com.corre.du.base.RESTCalls;
import com.corre.du.utils.PayloadConvertor;
import com.corre.du.utils.URI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.corre.du.base.Assertions.verifyStatusCode;
import static com.corre.du.base.Base.logout;

public class queryCompanyDetailTest {
        private String sessionId;
        Response response;

        @BeforeMethod
        public void setUp(){
            sessionId = Base.doLogin();
        }

        @Test
        public void queryCompanyDetailTest(){
            String URL = URI.getEndPoint("/api/proxy/crawl/query_status?company=%E6%B5%99%E6%B1%9F%E7%BB%BF%E5%9C%B0%E8%83%BD%E6%BA%90%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8");
            response = RESTCalls.GETrequest(URL);
            String strResponse = response.getBody().asString();
            JsonPath jsonPath = new JsonPath(strResponse);
            verifyStatusCode(response,200);
    }

        @AfterMethod
        public void tearDown(){
            logout();
        }
}


