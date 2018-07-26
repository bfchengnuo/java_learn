package com.jas.amq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Jas
 * @create 2018-04-13 15:25
 **/
public class Producer {

    private static final String REMOTE_URL = "tcp://192.168.248.136:61616";
    private static final String QUEUE_NAME = "queue-test";
    
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ActiveMQConnectionFactory(REMOTE_URL);
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUE_NAME);

        MessageProducer producer = session.createProducer(destination);
        for(int i = 0; i < 10; i++){
            TextMessage message = session.createTextMessage("create message " + i);
            producer.send(message);
            System.out.println("消息已发送 ：" + message.getText());
        }

        connection.close();
    }
}
