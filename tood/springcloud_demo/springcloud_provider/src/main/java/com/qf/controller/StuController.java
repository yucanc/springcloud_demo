package com.qf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yucan
 * @Date 2019/8/21
 */
@RestController
@RequestMapping("/stu")
public class StuController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/query/{id}")
    public String queryName(@PathVariable Integer id){

        //调用service -> dao查询学生姓名
        return "id为"+"学生姓名是：小明"+port;
    }
}
