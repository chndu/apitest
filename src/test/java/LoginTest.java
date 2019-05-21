import com.corre.du.base.RESTCalls;
import com.corre.du.utils.PayloadConvertor;
import com.corre.du.utils.URI;
import io.restassured.path.json.JsonPath;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
    Response response;

    private static Logger log = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void doLogin() throws Exception{
        log.info("Starting testcase: login");

        String loginPayload = PayloadConvertor.generatePayloadString("Login.json");

        System.out.println(loginPayload);

        String endPointURI = URI.getEndPoint("/api/user/login");

        response = RESTCalls.POSTrequest(endPointURI,loginPayload);

        String strResponse = response.getBody().asString();

        JsonPath jsonPath = new JsonPath(strResponse);


        String sessionId = jsonPath.getString("access_token");
        System.out.println(sessionId);

    }
}
