package com.hutatar;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestServiceImpl implements TestService {

    private final LoadBalancerClient loadBalancerClient;
    private final RestTemplate restTemplate;

    public TestServiceImpl(LoadBalancerClient loadBalancerClient) {
        this.loadBalancerClient = loadBalancerClient;
        this.restTemplate = new RestTemplate();
    }

    @HystrixCommand(fallbackMethod = "reliable")
    @Override
    public String get(){
        ServiceInstance users = loadBalancerClient.choose("users");
        String forObject = restTemplate.getForObject(users.getUri() + "/word", String.class);
        return forObject;
    }

    public String reliable() {
        return "reliable";
    }
}
