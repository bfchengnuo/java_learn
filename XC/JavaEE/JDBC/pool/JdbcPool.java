import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/**
 * Created by 冰封承諾Andy on 5/2/2017.
 * 连接池
 * 简单说就是实现 DataSource 接口，这个接口只有两个方法，其他都是继承过来的
 */
public class JdbcPool implements DataSource {
    // 设计到频繁删改 使用链表结构效率好一点
    private static LinkedList<Connection> mList = new LinkedList<>();
    private static Properties prop = new Properties();

    static {
        try {
            prop.load(JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            Class.forName(prop.getProperty("driver"));
            // 获取 10 个连接
            for (int i = 0; i < 10; i++) {
                mList.add(DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password")));
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {

        if (mList.size() <= 0) {
            throw new RuntimeException("数据库正忙....请稍后再获取");
        }

        Connection conn = mList.removeFirst();
        // 进行装饰
        MyConn myConn = new MyConn(conn);
        return myConn;
    }


    /**
     * 使用装饰模式增强 close，使其关闭的时候添加回连接池中
     * 有点繁琐，最好还是使用 动态代理（aop 面向切面，拦截技术）
     *
     * 装饰步骤
     *   1.定义一个类，实现被增强类相同的接口
     *   2.定义一个变量，记住被增强对象
     *   3.定义一个构造函数，接收被增强对象
     *   4.覆盖想增强的方法
     *   5.对于不想增强的方法，直接调用目标对象的方法
     */
    class MyConn implements Connection{
        private Connection conn;

        public MyConn(Connection conn) {
            this.conn = conn;
        }

        @Override
        public Statement createStatement() throws SQLException {
            return this.conn.createStatement();
        }

        @Override
        public PreparedStatement prepareStatement(String sql) throws SQLException {
            return this.conn.prepareStatement(sql);
        }

        @Override
        public CallableStatement prepareCall(String sql) throws SQLException {
            return this.conn.prepareCall(sql);
        }

        // 下面的覆盖和上面一样，不写了，方法过多使用装饰模式就有点繁琐了
        @Override
        public String nativeSQL(String sql) throws SQLException {
            return null;
        }

        @Override
        public void setAutoCommit(boolean autoCommit) throws SQLException {

        }

        @Override
        public boolean getAutoCommit() throws SQLException {
            return false;
        }

        @Override
        public void commit() throws SQLException {

        }

        @Override
        public void rollback() throws SQLException {

        }

        @Override
        public void close() throws SQLException {
            // 进行自定义
            mList.add(conn);
        }

        @Override
        public boolean isClosed() throws SQLException {
            return false;
        }

        @Override
        public DatabaseMetaData getMetaData() throws SQLException {
            return null;
        }

        @Override
        public void setReadOnly(boolean readOnly) throws SQLException {

        }

        @Override
        public boolean isReadOnly() throws SQLException {
            return false;
        }

        @Override
        public void setCatalog(String catalog) throws SQLException {

        }

        @Override
        public String getCatalog() throws SQLException {
            return null;
        }

        @Override
        public void setTransactionIsolation(int level) throws SQLException {

        }

        @Override
        public int getTransactionIsolation() throws SQLException {
            return 0;
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return null;
        }

        @Override
        public void clearWarnings() throws SQLException {

        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return null;
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return null;
        }

        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return null;
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

        }

        @Override
        public void setHoldability(int holdability) throws SQLException {

        }

        @Override
        public int getHoldability() throws SQLException {
            return 0;
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            return null;
        }

        @Override
        public Savepoint setSavepoint(String name) throws SQLException {
            return null;
        }

        @Override
        public void rollback(Savepoint savepoint) throws SQLException {

        }

        @Override
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {

        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return null;
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
            return null;
        }

        @Override
        public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
            return null;
        }

        @Override
        public Clob createClob() throws SQLException {
            return null;
        }

        @Override
        public Blob createBlob() throws SQLException {
            return null;
        }

        @Override
        public NClob createNClob() throws SQLException {
            return null;
        }

        @Override
        public SQLXML createSQLXML() throws SQLException {
            return null;
        }

        @Override
        public boolean isValid(int timeout) throws SQLException {
            return false;
        }

        @Override
        public void setClientInfo(String name, String value) throws SQLClientInfoException {

        }

        @Override
        public void setClientInfo(Properties properties) throws SQLClientInfoException {

        }

        @Override
        public String getClientInfo(String name) throws SQLException {
            return null;
        }

        @Override
        public Properties getClientInfo() throws SQLException {
            return null;
        }

        @Override
        public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
            return null;
        }

        @Override
        public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
            return null;
        }

        @Override
        public void setSchema(String schema) throws SQLException {

        }

        @Override
        public String getSchema() throws SQLException {
            return null;
        }

        @Override
        public void abort(Executor executor) throws SQLException {

        }

        @Override
        public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

        }

        @Override
        public int getNetworkTimeout() throws SQLException {
            return 0;
        }


        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return null;
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return false;
        }
    }


    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
