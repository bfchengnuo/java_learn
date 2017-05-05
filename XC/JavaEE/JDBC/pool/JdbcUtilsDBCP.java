package com.bfchengnuo;


import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by 冰封承諾Andy on 4/27/2017.
 * JDBC 的工具类
 * 用来获取 conn ，使用连接池  DBCP
 */
public class JdbcUtilsDBCP {
    private static DataSource ds = null;
    private static Properties prop = new Properties();

    // 使用静态代码块保证只加载一次
    static {
        try {
            prop.load(JdbcUtilsDBCP.class.getClassLoader().getResourceAsStream("dbcp.properties"));
            ds = BasicDataSourceFactory.createDataSource(prop);
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
