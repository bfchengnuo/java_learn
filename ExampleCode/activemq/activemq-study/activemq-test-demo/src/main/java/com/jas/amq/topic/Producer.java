package com.jas.amq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author Jas
 * @create 2018-04-13 15:31
 **/
public class Producer {
    private static final String REMOTE_URL = "tcp://192.168.248.136:61616";
    private static final String TOCPI_NAME = "topic-test";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ActiveMQConnectionFactory(REMOTE_URL);
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic(TOCPI_NAME);

        MessageProducer producer = session.createProducer(destination);
        for(int i = 0; i < 10; i++){
            TextMessage message = session.createTextMessage("create message " + i);
            producer.send(message);
            System.out.println("消息已发送 ：" + message.getText());
        }

        connection.close();
    }
}
