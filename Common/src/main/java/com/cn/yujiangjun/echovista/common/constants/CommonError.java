package com.cn.yujiangjun.echovista.common.constants;

import com.cn.yujiangjun.echovista.base.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.cn.yujiangjun.echovista.base.constants.CommonConstants.FAIL_CODE;

@Getter
@AllArgsConstructor
public enum CommonError implements BaseEnum {


    PARAMS_NOT_EXISTS(FAIL_CODE,"参数不存在"),
    DEL_FLAG_YES_FORBIDDEN_OPERATION(FAIL_CODE,"当前已被删除，禁止操作"),
    SURVEY_CUR_STATUS_FORBIDDEN_EDIT(FAIL_CODE,"当前问卷状态禁止编辑"),
    SURVEY_CUR_STATUS_FORBIDDEN_DEL(FAIL_CODE,"当前问卷状态禁止删除"),
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
