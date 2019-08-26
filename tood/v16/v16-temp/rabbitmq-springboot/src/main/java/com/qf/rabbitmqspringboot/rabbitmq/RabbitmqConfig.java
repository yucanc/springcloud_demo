package com.qf.rabbitmqspringboot.rabbitmq;

import com.qf.rabbitmqspringboot.common.CommonConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;

/**
 * @author yucan
 * @Date 2019/8/15
 */
@Configuration
public class RabbitmqConfig {

    public Queue initQueue(){
        return new Queue(CommonConstant.QUEUE_NAME,false,false,false);
    }
}
