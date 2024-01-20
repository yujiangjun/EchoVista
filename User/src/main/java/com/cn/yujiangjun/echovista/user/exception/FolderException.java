package com.cn.yujiangjun.echovista.user.exception;

import com.cn.yujiangjun.echovista.base.exception.BizException;
import com.cn.yujiangjun.echovista.user.enums.ErrorEnums;

public class FolderException extends BizException {
    public FolderException(String message, int code) {
        super(message, code);
    }

    public FolderException(ErrorEnums.FolderEnum error) {
        this(error.getValue(), error.getCode());
    }
}
