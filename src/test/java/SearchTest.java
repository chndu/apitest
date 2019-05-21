import com.corre.du.base.RESTCalls;
import com.corre.du.utils.PayloadConvertor;
import com.corre.du.utils.URI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.corre.du.base.Base;
import com.corre.du.base.Assertions;

import static com.corre.du.base.Assertions.*;
import static org.apache.log4j.varia.ExternallyRolledFileAppender.OK;

public class SearchTest {
  private String sessionId;
  Response response;
  String msg = OK;

  @BeforeMethod
    public void setUp(){
      sessionId = Base.doLogin();
  }

  @Test
    public void searchTest(){
      String URL = URI.getEndPoint("/api/graph/group_list");
      String searchList = PayloadConvertor.generatePayloadString("searchList.json");
      response = RESTCalls.POSTrequest(URL,searchList,sessionId);
      String strResponse = response.getBody().asString();

      JsonPath jsonPath = new JsonPath(strResponse);
      String status = jsonPath.getString("msg");
      System.out.println(status);
      verifyStatusCode(response,200);
      Assert.assertEquals(status,msg,"判断响应状态码");



  }
}
