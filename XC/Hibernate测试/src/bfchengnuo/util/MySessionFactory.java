package com.bfchengnuo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by 冰封承諾Andy on 2017/6/28.
 * SessionFactory 加载占用资源太大，为了避免重复调用做成工具类
 * 设置类为 final 防止被继承，然后使用单例模式
 */
final public class MySessionFactory {
    private static SessionFactory sessionFactory = null;

    private MySessionFactory() {
    }

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
