import java.sql.*;

/**
 * Created by 冰封承諾Andy on 4/27/2017.
 * JDBC 入门
 */
public class Main {
    // URL 后面建议加 ?useUnicode=true&characterEncoding=UTF-8 属性来确保编码
    // 如果是连本机可以省略：jdbc:mysql:///test
    private static String url = "jdbc:mysql://115.159.215.242:3306/test";
    private static String userName = "Loli";
    private static String password = "123456";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 1. 加载驱动,推荐第二种
            // 第一种会强依赖 jar 包，并且会被加载两次 看源码的静态代码块
            // DriverManager.registerDriver(new Driver());
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 获取链接
            conn = DriverManager.getConnection(url, userName, password);

            // 3. 获取向数据库发sql语句的 statament 对象
            statement = conn.createStatement();

            // 4. 向数据库发送 SQL，获取结果集
            resultSet = statement.executeQuery("SELECT * FROM users;");

            // 5. 从结果集获取数据
            while (resultSet.next()) {
                System.out.println(resultSet.getObject("id"));
                System.out.println(resultSet.getObject("name"));
                System.out.println(resultSet.getObject("sex"));
            }
        } finally {
            // 6. 释放链接，顺序是反着的
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                // 更严谨可以加
                resultSet = null;
            }

            if (statement != null) {
                try {
                    statement.close();
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

}
