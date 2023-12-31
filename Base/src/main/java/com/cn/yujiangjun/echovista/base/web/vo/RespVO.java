package com.cn.yujiangjun.echovista.base.web.vo;

import com.cn.yujiangjun.echovista.base.exception.BizException;

import static com.cn.yujiangjun.echovista.base.constants.CommonConstants.*;

public class RespVO {
    private RespVO() {}

    public static <T> Resp<T> success(T data){
        return new Resp<>(SUCCESS_CODE, SUCCESS_MES, data);
    }

    public static <T> Resp<T> fail(){
        return new Resp<>(FAIL_CODE,FAIL_MES,null);
    }

    public static <T> Resp<T> custom(int code,String message,T data){
        return new Resp<>(code,message,data);
    }
    public static <T> Resp<T> custom(BizException exception){
        return new Resp<>(exception.getCode(), exception.getMessage(), null);
    }


}
