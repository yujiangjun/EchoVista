package com.cn.yujiangjun.echovista.common.constants;

import com.cn.yujiangjun.echovista.base.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SurveyStatusEnum implements BaseEnum {

    INIT(0,"初始化"),
    DRAFT(1,"草稿"),
    PUBLISH(2,"已发布"),
    STOP_COLLECTED(3,"停止收集")
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
