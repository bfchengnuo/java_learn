package com.bfchengnuo.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 冰封承諾Andy on 2017/7/16.
 * 每一次获取都消耗大量资源，不如做成静态，集成在工具类中
 */
final public class ApplicationContextUtil {
    private static ApplicationContext ac = null;

    static {
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    private ApplicationContextUtil() {}

    public static ApplicationContext getAc() {
        return ac;
    }


    // 使用此方法获取 bean 不常用，会懒加载
    private static void getBeanFactory() {
        BeanFactory bf = new ClassPathXmlApplicationContext("applicationContext.xml");
        // User user = (User) bf.getBean("user");
        // System.out.println(user);
    }
}
