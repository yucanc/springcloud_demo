package com.qf.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yucan
 * 生产者，用于发送消息
 */
public class Producer {

    private static final String QUEUE_NAME = "simple-queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.36.141.146");
        factory.setUsername("java1904");
        factory.setPassword("root");
        factory.setPort(5672);
        factory.setVirtualHost("/java1904");

        Connection connection = factory.newConnection();
        //2.创建一个跟服务器交互的通道
        Channel channel = connection.createChannel();
        //3.声明队列,如果当前队列不存在，则会主动创建，如果存在，则不需要做任何操作
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //4.发送消息到队列
        String message = "如果没有梦想，那么跟咸鱼有什么区别！";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("发送成功！");
    }
}
