import com.corre.du.base.RESTCalls;
import com.corre.du.functioins.Function;
import com.corre.du.functioins.IdNoFunction;
import com.corre.du.utils.RandomUtil;
import com.corre.du.utils.URI;
import io.restassured.response.Response;
import org.apache.commons.lang3.ClassUtils;
import org.testng.annotations.Test;

import com.corre.du.functioins.*;

public class phoneTest {



    @Test
    void idTest(){
        IdNoFunction idNoFunction = new IdNoFunction();

        String[] id = {"北京市"};
        String Tid = idNoFunction.excute(id);
        System.out.println(Tid);
    }

    @Test
    void phoneTest(){
        PhoneFunction phoneFunction = new PhoneFunction();
        String[] phone = {"135"};
        String pId = phoneFunction.excute(phone);
        System.out.println(pId);

    }

    @Test
    void randomTest(){
        RandomFunction randomFunction = new RandomFunction();
        String[] randonNum = {"12"};
        String rNum = randomFunction.excute(randonNum);
        System.out.println(rNum);
    }

}
