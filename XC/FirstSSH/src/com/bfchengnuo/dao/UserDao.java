package com.bfchengnuo.dao;

import org.hibernate.SessionFactory;

/**
 * Created by 冰封承諾Andy on 2017/8/31.
 *
 * 暂时空着吧，栗子就不做的太复杂了
 */
public class UserDao {
    private SessionFactory sessionFactory;



    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
