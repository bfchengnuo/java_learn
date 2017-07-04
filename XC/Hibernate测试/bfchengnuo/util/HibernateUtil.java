package com.bfchengnuo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2017/6/29.
 * 改进后的工具类
 * 可以返回全新的 Session 和 线程绑定的 Session
 */
final public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    // 线程局部模式
    private static ThreadLocal<Session> threadLocal = new ThreadLocal<>();

    private HibernateUtil() {
    }

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

    // 通用的查询语句
    public static List executeQuery(String hql, Object[] parameters) {
        Session session = null;
        List list = null;

        try {
            session = openSession();
            Query query = session.createQuery(hql);
            // 参数绑定判断
            if (parameters != null && parameters.length > 0) {
                for (int i = 0; i < parameters.length; i++) {
                    query.setParameter(i, parameters[i]);
                }
            }
            list = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return list;
    }
}
