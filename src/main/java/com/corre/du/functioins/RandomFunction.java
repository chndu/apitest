package com.corre.du.functioins;

import com.corre.du.utils.RandomUtil;

public class RandomFunction implements Function {
    @Override
    public String excute(String[] args){

        int len = args.length;
        int length = 6;
        boolean flag = false; //默认false ,true存数字
        if(len > 0){ //第一个参数字符串长度
            length = Integer.valueOf(args[0]);
        }
        if (len > 1){//第二个参数是否存字符串
            flag = Boolean.valueOf(args[1]);
        }
        return RandomUtil.getRandom(length,flag);

    }

    @Override
    public String getReferenceKey(){
        return "random";
    }

}
