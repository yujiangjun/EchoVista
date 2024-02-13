package com.cn.yujiangjun.echovista.common.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommonInterceptor(new CommonWebReqInterceptor()))
                .excludePathPatterns("/inner/user/login/","/survey/**");
    }
}
