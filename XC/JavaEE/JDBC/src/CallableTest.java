import java.sql.*;

/**
 * Created by 冰封承諾Andy on 5/1/2017.
 * 调用存储过程
 * 存储过程简单说就是定义在数据库里的函数，所以就是调用函数
 */
public class CallableTest {
    public static void main(String[] args) {
        Connection conn = null;
        CallableStatement st = null; // 注意
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            st = conn.prepareCall("{call demo(?,?)}");
            st.setString(1,"lolicon");
            // 设置输出的类型
            st.registerOutParameter(2,Types.VARCHAR);
            st.execute();

            // 获取存储过程的输出值
            String str = st.getString(2);
            System.out.println(str);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
