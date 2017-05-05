package com.bfchengnuo;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by 冰封承諾Andy on 4/27/2017.
 * JDBC 的工具类
 * 用来获取 conn ，使用连接池  DBCP
 */
public class JdbcUtilsC3P0 {
    private static ComboPooledDataSource ds = null;

    // 使用静态代码块保证只加载一次
    static {
        try {
            ds = new ComboPooledDataSource();

            /*
            // 如果采用的是配置文件，下面的内容可以不写
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test");
            ds.setUser("Loli");
            ds.setPassword("123456");
            // 设置初始连接池的大小！
            ds.setInitialPoolSize(2);
            // 设置连接池的最小值！
            ds.setMinPoolSize(1);
            // 设置连接池的最大值！
            ds.setMaxPoolSize(10);
            // 设置连接池中的最大 Statements 数量！
            ds.setMaxStatements(50);
            // 设置连接池的最大空闲时间！
            ds.setMaxIdleTime(60);
            */
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }

    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
