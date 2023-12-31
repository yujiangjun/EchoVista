package com.cn.yujiangjun.echovista.base.exception;

import com.cn.yujiangjun.echovista.base.web.vo.Resp;
import com.cn.yujiangjun.echovista.base.web.vo.RespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.cn.yujiangjun.echovista.base.constants.CommonConstants.FAIL_CODE;

@RestControllerAdvice
@Slf4j
public class ExceptionResolver {

    @ExceptionHandler(BizException.class)
    public Resp<Void> resolveBizException(BizException e){
        if (log.isDebugEnabled()){
            log.debug("发生了系统业务异常:",e);
        }
        return RespVO.custom(e);
    }

    @ExceptionHandler(RuntimeException.class)
    public Resp<Void> resolveRuntimeException(RuntimeException e){
        return RespVO.custom(FAIL_CODE,e.getMessage(),null);
    }

    @ExceptionHandler(Exception.class)
    public Resp<Void> resolveRuntimeException(Exception e){
        return RespVO.custom(FAIL_CODE,e.getMessage(),null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Resp<Void> resolveMethodArgumentNotValidException(MethodArgumentNotValidException e){
        if (log.isDebugEnabled()){
            log.debug("请求参数绑定异常:",e);
        }
        return RespVO.custom(FAIL_CODE,e.getMessage(),null);
    }
}
