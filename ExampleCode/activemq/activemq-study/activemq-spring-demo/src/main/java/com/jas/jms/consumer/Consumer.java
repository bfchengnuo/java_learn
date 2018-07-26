package com.jas.jms.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jas
 * @create 2018-04-14 10:19
 **/
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    }
}
