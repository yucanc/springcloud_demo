package com.qf.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yucan
 * @Date 2019/8/22
 */
@FeignClient(value = "SERVER-PROVIDER",fallback = StuServiceFallback.class)
public interface IStuService {

    @RequestMapping("/stu/query/{id}")
    String queryName(@PathVariable("id") Integer id);
}
