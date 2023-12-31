package com.cn.yujiangjun.echovista.user.exception;

import com.cn.yujiangjun.echovista.base.exception.BizException;
import com.cn.yujiangjun.echovista.user.enums.ErrorEnums;

public class LoginException extends BizException {
    public LoginException(String message, int code) {
        super(message, code);
    }

    public LoginException(ErrorEnums.LoginEnum error) {
        this(error.getValue(), error.getCode());
    }
}
