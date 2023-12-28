package com.cn.yujiangjun.echovista;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
@AllArgsConstructor
public class IndexController {

    private final DiscoveryClient discoveryClient;

    private final MyConfig myConfig;

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
