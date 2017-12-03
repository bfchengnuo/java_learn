package com.bfchengnuo.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by 冰封承諾Andy on 2017/11/14.
 * 消息消费者
 */
public class AppConsumer {
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

        // 6.创建一个消费者
        MessageConsumer consumer = session.createConsumer(destination);

        // 7.创建监听器（异步监听）
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage msg = (TextMessage) message;
                try {
                    System.out.println(msg.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        // 9.关闭连接(监听器异步，应该在程序退出时关闭)
        // connection.close();
    }
}
