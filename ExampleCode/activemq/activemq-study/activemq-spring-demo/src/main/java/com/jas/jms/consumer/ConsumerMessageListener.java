package com.jas.jms.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Jas
 * @create 2018-04-14 10:07
 **/
public class ConsumerMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("接收已接收：" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
