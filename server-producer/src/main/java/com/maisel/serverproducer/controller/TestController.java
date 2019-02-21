package com.maisel.serverproducer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @aucthor:jjx
 * @Create:2019-01-25 21:10
 */
@RestController
public class TestController {

    @Value("${server.port}")
    String port;
    @RequestMapping("testProducer")
    public String testProducer(String name) {

        return "name是：" +name+";    port是:" + port;
    }
}
