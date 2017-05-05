package com.bfchengnuo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by 冰封承諾Andy on 5/2/2017.
 * 开源库的连接池测试
 */
public class Main {
    public static void main(String[] args) {
        // DBCPTest();
        C3P0Test();
    }

    private static void C3P0Test() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtilsC3P0.getConnection();
            System.out.println(conn.getClass().getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtilsC3P0.release(conn, st, rs);
        }
    }

    private static void DBCPTest() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtilsDBCP.getConnection();
            System.out.println(conn.getClass().getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtilsDBCP.release(conn, st, rs);
        }
    }
}
