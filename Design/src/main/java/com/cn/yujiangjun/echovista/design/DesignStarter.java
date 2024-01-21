package com.cn.yujiangjun.echovista.design;

import com.cn.yujiangjun.echovista.base.utils.ContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.cn.yujiangjun.echovista")
@EnableScheduling
@EnableDiscoveryClient
public class DesignStarter {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DesignStarter.class, args);
        ContextUtil.setContext(context);
    }
}
