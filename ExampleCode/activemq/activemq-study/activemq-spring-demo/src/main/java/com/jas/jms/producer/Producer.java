package com.jas.jms.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jas
 * @create 2018-04-14 9:46
 **/
public class Producer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService producerService = context.getBean(ProducerService.class);

        for (int i = 0; i < 10; i++) {
            producerService.sendMessage("test message：" + i);
        }
        
        // 关闭 IoC 容器
        context.close();
    }
}
