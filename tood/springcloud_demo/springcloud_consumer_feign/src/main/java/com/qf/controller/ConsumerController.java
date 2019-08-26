package com.qf.controller;

import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yucan
 * @Date 2019/8/22
 */
@RestController
@RequestMapping("/feign")
public class ConsumerController {

    @Autowired
    private IStuService stuService;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("--->" + Thread.currentThread().getName()+"---->"+this.hashCode());

        String result = stuService.queryName(200);

        return "调用微服务返回结果：" + result;
    }
}
