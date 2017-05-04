import java.sql.*;

/**
 * Created by 冰封承諾Andy on 5/1/2017.
 * 使用事务
 */
public class TransactionTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            // 关闭自动提交
            conn.setAutoCommit(false);
            String sql1 = "update users set rmb = rmb-100 where name='lolicon'";
            String sql2 = "update users set rmb = rmb+100 where name='loli'";

            st = conn.prepareStatement(sql1);
            st.executeUpdate();

            st = conn.prepareStatement(sql2);
            st.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

    // 自定义事务的回滚点以及手动回滚事务
    private static void custPoint() throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Savepoint sp = null;
        try {
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);

            String sql1 = "update users set rmb = rmb-100 where name='lolicon'";
            String sql2 = "update users set rmb = rmb+100 where name='loli'";

            st = conn.prepareStatement(sql1);
            st.executeUpdate();

            // 设置回滚点
            sp = conn.setSavepoint();

            st = conn.prepareStatement(sql2);
            st.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            // 手动进行回滚，记得进行 commit
            if (conn != null) {
                conn.rollback(sp);
                conn.commit();
            }
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }

    // 设置隔离级别
    private static void test() throws SQLException {
        Connection conn = JdbcUtils.getConnection();

        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        conn.setAutoCommit(false);

        //TODO

        JdbcUtils.release(conn,null,null);
    }
}
