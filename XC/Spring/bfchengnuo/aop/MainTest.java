package com.bfchengnuo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 冰封承諾Andy on 2017/7/21.
 * 测试类
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/bfchengnuo/aop/beans.xml");
        Loli loli = (Loli) ac.getBean("proxyFactoryBean");
        loli.hug();
        System.out.println("----------------");
        System.out.println(loli.speak("bfchengnuo"));
    }
}
