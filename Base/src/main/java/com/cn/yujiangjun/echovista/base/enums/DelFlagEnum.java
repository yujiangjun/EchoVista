package com.cn.yujiangjun.echovista.base.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DelFlagEnum implements BaseEnum {

    YES(1,"是"),
    NO(0,"否"),
    ;

    private final int code;
    private final String value;


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getValue() {
        return value;
    }
}
