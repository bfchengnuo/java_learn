package com.bfchengnuo.factory;

import java.sql.ResultSet;

/**
 * Created by 冰封承諾Andy on 4/28/2017.
 * UserDao 的具体实现类
 * 用于工厂模式具体创建的对象，配置在 dao.properties 中
 * 测试例子，没有按要求进行分包
 */
public class UserDaoJdbcImpl implements UserDao {
    @Override
    public int add(String sql) {
        return 0;
    }

    @Override
    public int remove(String sql) {
        return 0;
    }

    @Override
    public int update(String sql) {
        return 0;
    }

    @Override
    public ResultSet query(String sql) {
        return null;
    }
}
