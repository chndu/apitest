package com.corre.du.functioins;

import com.corre.du.utils.RegisterLocationUtil;
import org.testng.annotations.Test;

import static com.corre.du.utils.IdNoUtil.*;

public class IdNoFunction implements Function{
    @Override
    public String excute(String[] args){
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(randomLocationCode(RegisterLocationUtil.registerLocation()));
        strBuffer.append(randomBirthday());
        strBuffer.append(randomCode());
        String eighteenth = verificationCode(strBuffer.toString());
        strBuffer.append(eighteenth);
        return strBuffer.toString();


    }




    @Override
    public String getReferenceKey() {
        return "idno";
    }



}
