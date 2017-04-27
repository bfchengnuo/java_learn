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
