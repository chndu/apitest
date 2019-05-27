package com.corre.du.functioins;

import com.corre.du.utils.PhoneUtil;

public class PhoneFunction implements Function {

    @Override
    public String excute(String[] args){
        return PhoneUtil.getPhone();
    }

    @Override
    public String getReferenceKey() {
        return "phone";
    }
}
