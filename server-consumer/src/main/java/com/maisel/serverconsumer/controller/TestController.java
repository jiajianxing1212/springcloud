package com.maisel.serverconsumer.controller;

import com.maisel.serverconsumer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @aucthor:jjx
 * @Create:2019-01-25 21:42
 */
@RestController
public class TestController {
    @Value("${server.port}")
    String port;
    @Autowired
    private TestService testService;

    @RequestMapping("testConsumer")
    public String testConsumer() {
        String s = testService.testBalancer1();
        return "当前是消费者，端口号是："+port+"下面是调用结果："+s;
    }
}
