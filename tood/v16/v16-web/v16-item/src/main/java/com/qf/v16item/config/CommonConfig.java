package com.qf.v16item.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yucan
 * @Date 2019/8/13
 */
@Configuration
public class CommonConfig {

    @Bean
    public ThreadPoolExecutor initThreadPoolExecutor(){
        //队列可能会撑爆内存
        //可能创建太多的线程对象 OOM
        Runtime runtime = Runtime.getRuntime();
        int processors = runtime.availableProcessors();
        //创建自定义线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(processors,processors*2,
                30L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));
        return pool;
    }
}
