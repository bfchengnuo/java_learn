package com.bfchengnuo.jdbc.utils;

import java.sql.*;
import java.util.Properties;

/**
 * Created by 冰封承諾Andy on 4/27/2017.
 * JDBC 的工具类
 * 用来获取 conn
 */
public class JdbcUtils {
    private static Properties prop = new Properties();

    // 使用静态代码块保证只加载一次
    static {
        try {
            prop.load(JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            Class.forName(prop.getProperty("driver"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
    }

    /**
     * 增删改通用方法
     *
     * @param sql    要执行的 SQL 语句
     * @param params SQL 语句中需要填充的参数
     * @throws SQLException conn 异常
     */
    public static void update(String sql, Object[] params) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = getConnection();
            st = conn.prepareStatement(sql);  // 预编译
            // 填充参数
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            st.executeUpdate();
        } finally {
            JdbcUtils.release(conn, st, null);
        }
    }

    public static Object query(String sql, Object[] params, ResultSetHandler handler) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            st = conn.prepareStatement(sql);  // 预编译
            // 填充参数
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            rs = st.executeQuery();
            // 回调
            return handler.handler(rs);
        } finally {
            JdbcUtils.release(conn, st, rs);
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
