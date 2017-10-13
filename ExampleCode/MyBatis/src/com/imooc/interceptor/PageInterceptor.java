package com.imooc.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.imooc.entity.Page;

/**
 * 分页拦截器
 */
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class PageInterceptor implements Interceptor {

  private String test;

  // 3. 处理拦截后要干什么，参数就是被拦截的对象
  // 只有拦截成功的才会执行这个方法，相当于动态代理中的那个 InvocationHandler
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
    // 通过 MetaObject 能达到使用反射获取属性的效果
    MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
    MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
    // 获取配置文件中 SQL 语句的 ID，判断是不是要分页功能，通过 id 命名结尾带有 ByPage
    String id = mappedStatement.getId();
    if(id.matches(".+ByPage$")) {
      BoundSql boundSql = statementHandler.getBoundSql();
      // 原始的SQL语句
      String sql = boundSql.getSql();
      // 查询总条数的SQL语句
      String countSql = "select count(*) from (" + sql + ")a";
      Connection connection = (Connection)invocation.getArgs()[0];
      PreparedStatement countStatement = connection.prepareStatement(countSql);
      // 获取并填充 SQL 中的参数
      ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
      parameterHandler.setParameters(countStatement); // 填充
      ResultSet rs = countStatement.executeQuery();

      // 获取在 service 层调用时传入的参数，也就是配置文件里的 parameterType
      Map<?,?> parameter = (Map<?,?>)boundSql.getParameterObject();
      Page page = (Page)parameter.get("page");
      if(rs.next()) {
        page.setTotalNumber(rs.getInt(1));
      }
      // 改造后带分页查询的SQL语句
      String pageSql = sql + " limit " + page.getDbIndex() + "," + page.getDbNumber();
      // 将改造后的 SQL 塞回 statementHandler，这样就偷梁换日了
      metaObject.setValue("delegate.boundSql.sql", pageSql);
    }
    // 返回主权，也就是继续执行 prepare 方法，这样会执行我们换的 statementHandler
    return invocation.proceed();
  }

  // 2. 负责拦截对象（请求）
  // 参数为被拦截的对象，如果判断成功返回的是代理类，否则是拦截对象本身
  // 这里相当于是拦截所有的要创建 statement 的对象
  @Override
  public Object plugin(Object target) {
    System.out.println(this.test);
    return Plugin.wrap(target, this);
  }

  // 1. 可以把注册时配置的参数加载进来
  @Override
  public void setProperties(Properties properties) {
    this.test = properties.getProperty("test");	
  }
}
