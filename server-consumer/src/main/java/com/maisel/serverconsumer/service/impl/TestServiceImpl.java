package com.maisel.serverconsumer.service.impl;

import com.maisel.serverconsumer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @aucthor:jjx
 * @Create:2019-01-25 21:39
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String testConsumer() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8803/testProducer?name=hhhh", String.class);
        String body = forEntity.getBody();
        return body;
    }

    @Override
    public String testBalancer() {
//        1.通过负载均衡得到一个要访问的地址
        ServiceInstance instance = loadBalancerClient.choose("SERVER-PRODUCER");
        String host = instance.getHost();
        int port = instance.getPort();
//        2.通过restTemplate进行服务调用
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://" + host + ":" + port + "/testProducer?name=hhhh", String.class);
        return forObject;

    }

    @Override
    public String testBalancer1() {
        String forObject = restTemplate.getForObject("http://SERVER-PRODUCER/testProducer?name=hhhh", String.class);
        return forObject;
    }

}
