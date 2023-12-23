package com.cn.yujiangjun.echovista;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "greeting")
@Data
public class MyConfig {

    private String message;
}
