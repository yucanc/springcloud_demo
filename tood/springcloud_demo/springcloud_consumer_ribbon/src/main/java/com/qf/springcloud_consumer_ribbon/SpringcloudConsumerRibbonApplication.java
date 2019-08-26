package com.qf.springcloud_consumer_ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.qf")
@EnableEurekaClient
@EnableHystrix
public class SpringcloudConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerRibbonApplication.class, args);

    }
     @Bean
     @LoadBalanced//springcloud负载均衡必须要用到的注解
     public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * 更改负载均衡策略
     * @return
     */

    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }
}
