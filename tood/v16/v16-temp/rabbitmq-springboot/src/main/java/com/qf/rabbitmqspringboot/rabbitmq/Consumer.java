package com.qf.rabbitmqspringboot.rabbitmq;

import com.qf.rabbitmqspringboot.common.CommonConstant;
import com.qf.rabbitmqspringboot.entity.ProductDTO;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yucan
 * @Date 2019/8/15
 * 消费者
 */
@Component
@RabbitListener(queues = CommonConstant.QUEUE_NAME)
public class Consumer {

    @RabbitHandler
    public void process(String message){
        System.out.println("接收到的消息为："+message);
    }

    @RabbitHandler
    public void process(ProductDTO productDTO){
        System.out.println(productDTO.getId()+"->"+productDTO.getName());
    }
}
