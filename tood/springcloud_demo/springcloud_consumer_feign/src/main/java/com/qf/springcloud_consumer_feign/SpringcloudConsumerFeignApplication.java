package com.qf.springcloud_consumer_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.qf")
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.qf.service")
public class SpringcloudConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerFeignApplication.class, args);
    }

}
