package com.qf.springcloud_eureka3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudEureka3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEureka3Application.class, args);
    }

}
