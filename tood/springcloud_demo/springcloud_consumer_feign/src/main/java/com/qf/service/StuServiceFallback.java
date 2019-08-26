package com.qf.service;

import org.springframework.stereotype.Component;

/**
 * @author yucan
 * @Date 2019/8/22
 */
@Component
public class StuServiceFallback implements IStuService {

    @Override
    public String queryName(Integer id) {
        return "查询id" + id + "学生姓名失败，请稍后再试！";
    }
}
