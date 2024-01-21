package com.cn.yujiangjun.echovista.common.exception;

import com.cn.yujiangjun.echovista.base.exception.BizException;
import com.cn.yujiangjun.echovista.common.constants.CommonError;

public class SurveyException extends BizException {
    public SurveyException(String message, int code) {
        super(message, code);
    }

    public SurveyException(CommonError error){
        super(error.getValue(), error.getCode());
    }

}
