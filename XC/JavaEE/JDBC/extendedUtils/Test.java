package com.bfchengnuo.jdbc;

import com.bfchengnuo.jdbc.utils.BeanHandler;
import com.bfchengnuo.jdbc.utils.BeanListHandler;
import com.bfchengnuo.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by 冰封承諾Andy on 4/27/2017.
 * 工具类的测试
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        // simpleTest();
        // extendedTest();
        extendedTest2();
    }

    // 测试返回是 List
    private static void extendedTest2() throws SQLException {
        String sql = "SELECT * FROM simpletab";
        Object[] params = {};
        List list = (List) JdbcUtils.query(sql, params, new BeanListHandler(SimpleTab.class));
        System.out.println(list.size());
    }

    // 扩展测试
    private static void extendedTest() throws SQLException {
        // String sql = "insert INTO simpletab VALUES (?,?)";
        // Object[] params = {2, "测试"};
        // JdbcUtils.update(sql,params);

        //language=MySQL
        String sql = "SELECT * FROM simpletab WHERE id=?";
        Object[] params = {2};
        SimpleTab bean = (SimpleTab) JdbcUtils.query(sql, params, new BeanHandler(SimpleTab.class));
        System.out.println(bean.getId());
        System.out.println(bean.getName());
    }

    private static void simpleTest() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "SELECT * FROM users";
            rs = st.executeQuery(sql);

            //TODO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
