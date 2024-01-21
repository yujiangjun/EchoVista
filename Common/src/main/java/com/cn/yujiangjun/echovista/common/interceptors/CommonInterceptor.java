package com.cn.yujiangjun.echovista.common.interceptors;

import cn.hutool.core.bean.BeanUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cn.yujiangjun.echovista.base.utils.ContextUtil;
import com.cn.yujiangjun.echovista.common.dto.LoginUserDTO;
import com.cn.yujiangjun.echovista.common.utils.JwtUtil;
import com.cn.yujiangjun.echovista.common.utils.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

@Slf4j
public class CommonInterceptor extends WebRequestHandlerInterceptorAdapter {
    public CommonInterceptor(WebRequestInterceptor requestInterceptor) {
        super(requestInterceptor);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        DecodedJWT verify = JwtUtil.verify(token);
//        Map<String, Claim> claims = verify.getClaims();
        RedisTemplate<String,Object> redisTemplate = ContextUtil.getBean(RedisTemplate.class,"redisTemplate");

        SessionUtil.setValue(BeanUtil.toBean(redisTemplate.boundHashOps(token).entries(), LoginUserDTO.class));
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        SessionUtil.remove();
    }
}
