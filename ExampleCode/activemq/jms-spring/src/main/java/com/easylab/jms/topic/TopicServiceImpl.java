package com.easylab.jms.topic;

import com.easylab.jms.producer.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/******************************
 * @author : liuyang
 * <p>ProjectName:jms-spring  </p>
 * @ClassName :  TopicServiceImpl
 * @date : 2018/6/24 0024
 * @time : 15:01
 * @createTime 2018-06-24 15:01
 * @version : 2.0
 * @description :
 *
 *
 *
 *******************************/


public class TopicServiceImpl implements IProducerService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Resource(name = "topicDestination")
    Destination destination;


    public void sendMessage(final String message) {

        // 使用JmsTemplate发送消息
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                // 创建一个消息
                TextMessage textMessage = session.createTextMessage(message);

                return textMessage;
            }
        });
        System.out.println("发送消息" + message);
    }
}
