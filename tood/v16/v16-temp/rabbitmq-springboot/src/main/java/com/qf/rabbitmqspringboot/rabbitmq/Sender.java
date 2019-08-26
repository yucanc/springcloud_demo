package com.qf.rabbitmqspringboot.rabbitmq;

import com.qf.rabbitmqspringboot.common.CommonConstant;
import com.qf.rabbitmqspringboot.entity.ProductDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yucan
 * @Date 2019/8/15
 * 生产者
 */
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message){
        rabbitTemplate.convertAndSend(CommonConstant.QUEUE_NAME,message);
    }

    public void send(ProductDTO productDTO){
        rabbitTemplate.convertAndSend(CommonConstant.QUEUE_NAME,productDTO);
    }
}
