package com.bfchengnuo;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
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
    // 随类加载而创建，内部其实是一个 Map 集合
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    // 使用静态代码块保证只加载一次
    static {
        try {
            ds = new ComboPooledDataSource();

            /*
            // 如果采用的是配置文件，下面的内容可以不写
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://115.152.145.242:3306/test");
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

    static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnectionThread() {
        // 便于 Dao 层的获取，一般来说获取的到的是开启事务的连接，获取不到就从连接池拿一个普通的
        try {
            // 得到当前线程上绑定的连接
            Connection conn = tl.get();
            // 判断是否为空，如果为空就从连接池获取一个，绑定到当前线程
            if (conn == null) {
                conn = getConnection();
                tl.set(conn);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void startTransaction() {
        // 便于 Server 层获取
        try {
            // 得到当前线程上绑定的连接
            Connection conn = tl.get();
            // 判断是否为空，如果为空就从连接池获取一个，绑定到当前线程
            if (conn == null) {
                conn = getConnection();
                tl.set(conn);
            }
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commintTransaction() {
        try {
            Connection conn = tl.get();
            if (conn != null) {
                conn.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            Connection conn = tl.get();
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 千万记得释放资源，否则 Map 集合会越来越大；只会移除当前线程的
            tl.remove();
        }
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
