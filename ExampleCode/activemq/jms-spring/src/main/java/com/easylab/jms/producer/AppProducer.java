package com.easylab.jms.producer;

import javafx.application.Application;
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


public class AppProducer {

    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");

        IProducerService service = context.getBean(IProducerService.class);

        for (int i = 0; i < 100; i++) {
            service.sendMessage("test" + i);
        }
        context.close();

    }

}
