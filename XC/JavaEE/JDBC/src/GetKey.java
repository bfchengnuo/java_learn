import java.sql.*;

/**
 * Created by 冰封承諾Andy on 5/1/2017.
 * 增删改的时候获取到主键，设置的自动增长时如何获取主键
 *
 * 补充关于指针的一些操作：
 * 下一行
 * rs.next();
 * 上一行
 * rs.previous();
 * 移动到指定行；可以是负数；如果传入1，相当于 first()；滚动后可以直接取数据
 * rs.absolute(2);
 * 移动到最前；第一行之前
 * rs.beforeFirst();
 * 移动到最后；最后一行之后
 * rs.afterLast();
 */
public class GetKey {

    public static void main(String[] args) {
        getID();
    }

    // 返回自动生成的主键 ID ，仅对于 insert 有效，因为只有插入的时候才会生成 ID
    private static void getID() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            // 第二个参数是是否返回主键，mysql 是默认返回可以不写，写上最好
            st = conn.prepareStatement("insert into keytemp (val) VALUES ('abcd')", Statement.RETURN_GENERATED_KEYS);
            st.executeUpdate();
            // 获取返回的主键
            rs = st.getGeneratedKeys();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
