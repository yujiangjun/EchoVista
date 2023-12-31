package com.cn.yujiangjun.echovista.common.constants;

import com.cn.yujiangjun.echovista.base.enums.BaseEnum;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrTokenEnum implements BaseEnum {
    SIGN_NOT_AGREEMENT(601,"签名不一致"),
    TOKEN_EXPIRED(602,"令牌过期"),
    ALGORITHM_MISMATCH(604,"算法不匹配"),
    INVALID_TOKEN(605,"无效令牌"),
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
