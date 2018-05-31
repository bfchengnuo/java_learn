package com.bfchengnuo.factory;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by 冰封承諾Andy on 2018/5/28.
 */
public class Factory {
    private static BasicDataSource ds = new BasicDataSource();

    static {
        Properties pro = new Properties();
        try {
            // Factory.class.getResourceAsStream 文件的目录为基目录，来寻找文件, / 为 classpath
            // classLoader 加载默认是 classpath
            InputStream is = Factory.class.getClassLoader().getResourceAsStream("db.properties");
            pro.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ds.setDriverClassName(pro.getProperty("m.driver"));
        ds.setUrl(pro.getProperty("m.url"));
        ds.setUsername(pro.getProperty("m.username"));
        ds.setPassword(pro.getProperty("m.pwd"));
    }

    public static DataSource getDs() {
        return ds;
    }

    public static Connection getConn() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
