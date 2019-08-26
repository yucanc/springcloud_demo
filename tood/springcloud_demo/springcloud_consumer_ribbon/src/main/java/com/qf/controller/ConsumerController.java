package com.qf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yucan
 * @Date 2019/8/21
 */
@RestController
@RequestMapping("/ribbon")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "fallBack")
    public String consumer(){
        System.out.println("--->访问的资源：" + Thread.currentThread().getName()  );
        String result = restTemplate.getForObject("http://SERVER-PROVIDER/stu/query/18",String.class);
        return "调用服务的提供者返回值为" + result;
    }

    /**
     * 降级方法
     * @return
     */
    public String fallBack(){
        return "服务器异常，请稍后再试！";
    }
}
