package com.cn.yujiangjun.echovista.common.interceptors;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.cn.yujiangjun.echovista.common.dto.LoginUserDTO;
import com.cn.yujiangjun.echovista.common.utils.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Slf4j
@Component
public class ModelCommonFieldFillHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        LoginUserDTO currentUser = SessionUtil.getValue();
        LoginUserDTO user = Optional.ofNullable(currentUser).orElseGet(() -> new LoginUserDTO("", "sys", ""));
        this.strictInsertFill(metaObject,"createdBy",String.class, user.userId());
        this.strictInsertFill(metaObject,"createdTime", Date.class, DateTime.now());
        this.strictInsertFill(metaObject,"updatedBy",String.class, user.userId());
        this.strictInsertFill(metaObject,"updatedTime", Date.class, DateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LoginUserDTO currentUser = SessionUtil.getValue();
        LoginUserDTO user = Optional.ofNullable(currentUser).orElseGet(() -> new LoginUserDTO("", "sys", ""));
        this.strictInsertFill(metaObject,"updatedBy",String.class, user.userId());
        this.strictInsertFill(metaObject,"updatedTime", Date.class, DateTime.now());
    }
}
