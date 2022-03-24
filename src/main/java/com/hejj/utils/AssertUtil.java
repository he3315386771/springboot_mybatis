package com.hejj.utils;

import com.hejj.exception.ParamsException;

public class AssertUtil {
    private AssertUtil(){}
    public static void isTrue(Boolean flag,String msg){
        if(flag){
            throw new ParamsException(msg);
        }
    }
}
