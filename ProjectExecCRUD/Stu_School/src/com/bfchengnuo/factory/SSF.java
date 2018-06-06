package com.bfchengnuo.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Created by 冰封承諾Andy on 2018/6/5.
 */
public class SSF {
    private static SqlSessionFactory ssf;

    public SSF() {
    }

    static {
        try {
            ssf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return ssf.openSession();
    }
}
