package com.bfchengnuo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by 冰封承諾Andy on 2017/6/29.
 * 改进后的工具类
 * 可以返回全新的 Session 和 线程绑定的 Session
 */
final public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    // 线程局部模式
    private static ThreadLocal<Session> threadLocal = new ThreadLocal<>();

    private HibernateUtil() {}

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    // 返回全新的 Session
    public static Session openSession() {
        return sessionFactory.openSession();
    }

    // 获取与线程相关的 Session
    public static Session getCurrentSession() {
        Session session = threadLocal.get();
        if (session == null) {
            session = sessionFactory.openSession();
            // 绑定到线程
            threadLocal.set(session);
        }
        return session;
    }
}
