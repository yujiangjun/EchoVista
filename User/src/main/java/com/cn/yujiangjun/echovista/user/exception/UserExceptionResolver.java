package com.cn.yujiangjun.echovista.user.exception;

import com.cn.yujiangjun.echovista.base.web.vo.Resp;
import com.cn.yujiangjun.echovista.base.web.vo.RespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class UserExceptionResolver {


    @ExceptionHandler(LoginException.class)
    public Resp<Void> resolveLoginException(LoginException e) {
        if (log.isDebugEnabled()) {
            log.debug("登录发生异常:", e);
        }
        return RespVO.custom(e);
    }
}
