import java.sql.*;

/**
 * Created by 冰封承諾Andy on 5/1/2017.
 * 批量操作数据库
 * 一般有两种方式 : 使用 statement 和 preparedStatement
 */
public class BatchTest {

    public static void main(String[] args) {
        // statementTest();
        preparedStatementTest();
    }

    // 使用 statement 方式
    // 可以同时执行不同类别的语句，但是效率低
    private static void statementTest() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();

            st.addBatch("insert into temp(id,value) VALUES (100,'lolicon')");
            st.addBatch("UPDATE temp SET id=101 WHERE id=1");
            st.executeBatch();
            st.clearBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

    // preparedStatement 方式
    // 只能执行相同的语句，用于批量插入、更新等；效率高
    private static void preparedStatementTest() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.prepareStatement("insert into temp (id, value) values (?,?);");

            // 插入 30 条数据，一次发送 30 条 SQL 语句
            for (int i = 0; i < 30; i++) {
                st.setInt(1, i);
                st.setString(2, "test" + i);
                // 添加到 List 集合
                st.addBatch();

                // 每满 10 条发送一次
                if (i % 10 == 0) {
                    st.executeBatch();
                    st.clearBatch();
                }

                st.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

}
