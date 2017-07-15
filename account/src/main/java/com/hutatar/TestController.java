package com.hutatar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/uri")
    public String get(){
        ServiceInstance users = loadBalancerClient.choose("users");
        return users.getUri().toString();
    }
}
