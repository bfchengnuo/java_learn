package com.bfchengnuo.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by 冰封承諾Andy on 2017/11/14.
 * 消息提供者
 */
public class AppProducer {
    private static final String URL = "tcp://127.0.0.1:61616";
    private static final String QUEUE_NAME = "queue-test";

    public static void main(String[] args) throws JMSException {
        // 1.创建 ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);

        // 2.创建连接
        Connection connection = connectionFactory.createConnection();

        // 3.启动连接
        connection.start();

        // 4.创建会话
        // 第一个参数是是否在事务中，第二个是自动提交
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 5.创建一个目标
        Destination destination = session.createQueue(QUEUE_NAME);

        // 6.创建一个生产者
        MessageProducer producer = session.createProducer(destination);

        // 7.创建消息/发送消息
        TextMessage message = session.createTextMessage("testMessage");
        producer.send(message);

        // 8.关闭连接
        connection.close();
    }
}
