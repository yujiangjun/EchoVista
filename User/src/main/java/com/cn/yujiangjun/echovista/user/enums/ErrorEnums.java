package com.cn.yujiangjun.echovista.user.enums;

import com.cn.yujiangjun.echovista.base.enums.BaseEnum;
import lombok.AllArgsConstructor;

import static com.cn.yujiangjun.echovista.base.constants.CommonConstants.FAIL_CODE;

public class ErrorEnums {

    @AllArgsConstructor
    public enum LoginEnum implements BaseEnum {
        LOGIN_PARAM_LOSE(FAIL_CODE, "登录账号或密码不能为空"),
        CURRENT_USER_NOT_EXIST(FAIL_CODE, "当前用户不存在"),
        LOGIN_PASSWORD_ERROR(FAIL_CODE, "登录账号或密码错误"),
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


    @AllArgsConstructor
    public enum FolderEnum implements BaseEnum{
        FOLDER_NOT_EXIST(FAIL_CODE,"当前目录不存在"),
        PARENT_FOLDER_NOT_EXIST(FAIL_CODE,"目标目录不存在"),
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
}
