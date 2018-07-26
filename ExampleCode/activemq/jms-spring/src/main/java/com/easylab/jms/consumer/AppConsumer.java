package com.easylab.jms.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import javax.jms.*;

/******************************
 * @author : liuyang
 * <p>ProjectName:jms-test  </p>
 * @ClassName :  AppProducer
 * @date : 2018/6/20 0020
 * @time : 20:46
 * @createTime 2018-06-20 20:46
 * @version : 2.0
 * @description :
 *
 *
 *
 *******************************/


public class AppConsumer {

   public static void main(String[] args) {

       ApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    }


}
