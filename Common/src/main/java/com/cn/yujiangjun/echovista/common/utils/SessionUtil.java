package com.cn.yujiangjun.echovista.common.utils;

import com.cn.yujiangjun.echovista.common.dto.LoginUserDTO;

public class SessionUtil {

    private SessionUtil(){}
    private static final ThreadLocal<LoginUserDTO> THREAD_LOCAL=new ThreadLocal<>();
    public static void setValue(LoginUserDTO value){
        THREAD_LOCAL.set(value);
    }

    public static LoginUserDTO getValue(){
        return THREAD_LOCAL.get();
    }
    public static void remove(){
        THREAD_LOCAL.remove();
    }
}
