package com.cn.yujiangjun.echovista.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.cn.yujiangjun.echovista")
@EnableScheduling
@EnableDiscoveryClient
public class UserStarter {
    public static void main(String[] args) {
        SpringApplication.run(UserStarter.class,args);
    }
}