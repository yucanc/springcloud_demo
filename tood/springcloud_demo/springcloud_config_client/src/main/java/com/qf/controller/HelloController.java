package com.qf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @user ken
 * @date 2019/8/22 15:49
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class HelloController {

    @Value("${com.name}")
    private String name;

    @RequestMapping("/client")
    public String client(){
        return "读取到配置：" + name;
    }
}
