package com.cn.yujiangjun.echovista.user;

import com.cn.yujiangjun.echovista.base.utils.ContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.cn.yujiangjun.echovista")
@EnableScheduling
@EnableDiscoveryClient
public class UserStarter {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UserStarter.class, args);
        ContextUtil.setContext(context);
    }
}