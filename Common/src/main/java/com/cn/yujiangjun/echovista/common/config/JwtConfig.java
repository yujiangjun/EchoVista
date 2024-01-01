package com.cn.yujiangjun.echovista.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtConfig implements Serializable {

    private String secret;

    private Integer expire;
}
