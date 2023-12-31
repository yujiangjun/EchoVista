package com.cn.yujiangjun.echovista.base.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException{

    private final int code;

    public BizException(String message, int code) {
        super(message);
        this.code = code;
    }
}
