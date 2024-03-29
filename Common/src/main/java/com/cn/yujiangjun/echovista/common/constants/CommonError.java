package com.cn.yujiangjun.echovista.common.constants;

import com.cn.yujiangjun.echovista.base.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.cn.yujiangjun.echovista.base.constants.CommonConstants.FAIL_CODE;

@Getter
@AllArgsConstructor
public enum CommonError implements BaseEnum {


    PARAMS_NOT_EXISTS(FAIL_CODE, "参数不存在"),
    CURRENT_SURVEY_NOT_EXISTS(FAIL_CODE, "当前问卷不存在"),
    CURRENT_SURVEY_STOP_COLLECTED(FAIL_CODE, "当前问卷已停止收集"),
    DEL_FLAG_YES_FORBIDDEN_OPERATION(FAIL_CODE, "当前已被删除，禁止操作"),
    SURVEY_CUR_STATUS_FORBIDDEN_EDIT(FAIL_CODE, "当前问卷状态禁止编辑"),
    SURVEY_CUR_STATUS_FORBIDDEN_DEL(FAIL_CODE, "当前问卷状态禁止删除"),
    CURRENT_QUESTION_NOT_EXISTS(FAIL_CODE, "当前问题不存在"),
    CURRENT_QUESTION_DELETED(FAIL_CODE, "当前问题已删除"),
    CURRENT_QUESTION_CONTENT_NOT_EXISTS(FAIL_CODE, "当前问题条目不存在"),
    CURRENT_QUESTION_CONTENT_DELETED(FAIL_CODE, "当前问题条目已删除"),
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
