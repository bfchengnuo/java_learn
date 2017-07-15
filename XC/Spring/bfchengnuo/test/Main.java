package com.bfchengnuo.test;

import com.bfchengnuo.domain.Loli;
import com.bfchengnuo.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 冰封承諾Andy on 2017/7/14.
 * 最简单的 Spring 测试程序
 */
public class Main {

    public static void main(String[] args) {
        getBeanAC();
        // getBeanFactory();

    }

    // 通过工厂获取 bean，只有在获取的时候（get）才会创建相应的 bean 对象
    // 不太常用
    private static void getBeanFactory() {
        BeanFactory bf = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) bf.getBean("user");
        System.out.println(user);
    }

    // 通过上下文来获取 bean；在初始化的时候就已经被创建（实例化）
    // 比较常用
    private static void getBeanAC() {
        // 解析配置文件并且创建其中的 bean 到内存中，非常耗费资源，一般写成工具类 单例模式
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Loli loli = (Loli) ac.getBean("loli");

        System.out.println(loli);
    }
}
