package com.bfchengnuo;

import com.bfchengnuo.jdbc.SimpleTab;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 冰封承諾Andy on 5/6/2017.
 * Apache 的 dbutils 工具类的测试
 */
public class DBUtilsTest {
    // 由构造方法获得
    private static Connection conn = null;

    public static void main(String[] args) throws SQLException {
        // test1();
        // test2();
        // test3();
        test4();
    }

    private static int updateExample(SimpleTab bean) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "UPDATE simpletab SET name=? WHERE id=?";
        Object[] param = {bean.getName(), bean.getId()};
        return qr.update(conn, sql, param);
    }

    private static SimpleTab findExample(int id) {
        try {
            QueryRunner qr = new QueryRunner();
            String sql = "SELECT * FROM simpletab WHERE id=?";
            Object[] param = {id};
            return qr.query(conn, sql, new BeanHandler<>(SimpleTab.class), param);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 使用事务；具体使用要按照三层架构分离，dao 层不允许有业务逻辑，只能执行 sql
    // 在 Server 层将 conn 创建好传进来
    // 比较好的方案是使用 ThreadLocal ，将 conn 绑定到线程上
    private static void test4() throws SQLException {
        QueryRunner qr = new QueryRunner();
        Connection conn = null;

        try {
            conn = JdbcUtilsC3P0.getConnection();
            conn.setAutoCommit(false);

            String sql1 = "UPDATE simpletab SET name='loli' WHERE id=1";
            qr.update(conn, sql1);

            String sql2 = "UPDATE simpletab SET name='loli' WHERE id=2";
            qr.update(conn, sql2);

            conn.commit();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    // 批量插入，批量操作
    private static void test3() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtilsC3P0.getDataSource());
        String sql = "INSERT INTO simpletab(id,name) VALUES (?,?)";
        Object[][] params = new Object[5][];
        for (int i = 0; i < 5; i++) {
            params[i] = new Object[]{i + 4, "test" + i};
        }
        qr.batch(sql, params);
    }

    // 简单查询
    private static void test2() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtilsC3P0.getDataSource());
        String sql = "SELECT * FROM simpletab";
        List<SimpleTab> list = qr.query(sql, new BeanListHandler<>(SimpleTab.class));
        System.out.println(list);
    }

    // 简单的插入，增删改都是一样的
    private static void test1() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtilsC3P0.getDataSource());
        String sql = "INSERT INTO simpletab(id,name) VALUES (?,?)";
        Object[] param = {3, "hello"};
        qr.update(sql, param);
    }

}
