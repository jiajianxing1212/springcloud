package com.maisel.serverproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServerProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerProducerApplication.class, args);
    }

}

