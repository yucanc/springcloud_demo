package com.qf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @user ken
 * @date 2019/8/22 15:00
 */
@RestController
public class FallBackController {

    @RequestMapping("/fallback")
    public String fallBack(){
        return "路由层面的降级方法！";
    }
}
