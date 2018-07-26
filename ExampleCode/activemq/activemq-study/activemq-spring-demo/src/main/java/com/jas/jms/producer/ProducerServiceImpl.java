package com.jas.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * @author Jas
 * @create 2018-04-14 9:21
 **/
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    JmsTemplate jmsTemplate;
    /**
     * 这里以 @Resource 方式注入目的地对象
     * 如果是发布者/订阅者模式，只选要修改 name 中的值为“activeMQTopic”即可
     */
    @Resource(name = "activeMQQueue")
    Destination destination;

    @Override
    public void sendMessage(final String message) {
       jmsTemplate.send(destination, new MessageCreator() {
           @Override
           public Message createMessage(Session session) throws JMSException {
               TextMessage textMessage = session.createTextMessage(message);
               return textMessage;
           }
       });
        System.out.println("消息已发送：" + message);
    }
}
