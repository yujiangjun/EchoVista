package com.cn.yujiangjun.echovista;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RequestMapping("/")
@Slf4j
public class ApplicationStarter {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyConfig myConfig;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class,args);
    }


    @GetMapping("/getServices")
    public List<String> getServiceList(){
        String description = discoveryClient.description();
        log.info("description:{}",description);
        return discoveryClient.getServices();
    }

    @GetMapping("/getCm")
    public String getCm(){
        log.info("description:{}",myConfig.getMessage());
        return myConfig.getMessage();
    }
}