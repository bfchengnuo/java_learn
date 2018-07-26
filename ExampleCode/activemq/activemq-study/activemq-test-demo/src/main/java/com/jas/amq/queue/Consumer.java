package com.jas.amq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Jas
 * @create 2018-04-13 15:27
 **/
public class Consumer {

    private static final String REMOTE_URL = "tcp://192.168.248.136:61616";
    private static final String QUEUE_NAME = "queue-test";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ActiveMQConnectionFactory(REMOTE_URL);
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUE_NAME);

        MessageConsumer consumer = session.createConsumer(destination);

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage message1 = (TextMessage) message;
                try {
                    System.out.println("消费者接收到消息：" +  message1.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        
    }
}
