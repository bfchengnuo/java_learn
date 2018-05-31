package com.bfchengnuo.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by 冰封承諾Andy on 2018/5/30.
 */
public class SF {
    private static SessionFactory sf;

    private SF() {
    }

    static {
        sf = new Configuration().configure().buildSessionFactory();
    }

    public static Session getSession() {
        return sf.openSession();
    }
}
