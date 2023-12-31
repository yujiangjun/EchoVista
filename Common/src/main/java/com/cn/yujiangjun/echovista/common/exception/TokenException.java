package com.cn.yujiangjun.echovista.common.exception;

import com.cn.yujiangjun.echovista.base.exception.BizException;
import com.cn.yujiangjun.echovista.common.constants.ErrTokenEnum;

public class TokenException extends BizException {
    public TokenException(String message, int code) {
        super(message, code);
    }

    public TokenException(ErrTokenEnum e){
        this(e.getValue(),e.getCode());
    }
}
