package com.easylab.jms.consumer;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/******************************
 * @author : liuyang
 * <p>ProjectName:jms-spring  </p>
 * @ClassName :  ConsumerMessageListener
 * @date : 2018/6/24 0024
 * @time : 9:16
 * @createTime 2018-06-24 9:16
 * @version : 2.0
 * @description :
 *
 *
 *
 *******************************/


public class ConsumerMessageListener implements MessageListener {

    public void onMessage(Message message) {

        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("接收消息" + textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
