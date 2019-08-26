package com.qf.rabbitmq.work;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yucan
 * 消费者，用于接收消息，进行处理
 */
public class MyConsumer1 {

    private static final String QUEUE_NAME = "work-queue";

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
        //3.消息者来处理消息
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"utf-8");
                System.out.println("消费者1接收到的消息为："+message);
            }
        };
        //4.消费者去监听队列
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
