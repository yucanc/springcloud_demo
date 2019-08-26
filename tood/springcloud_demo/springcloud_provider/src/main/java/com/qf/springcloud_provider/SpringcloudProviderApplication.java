package com.qf.springcloud_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.qf")
@EnableEurekaClient
public class SpringcloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProviderApplication.class, args);
    }

}
