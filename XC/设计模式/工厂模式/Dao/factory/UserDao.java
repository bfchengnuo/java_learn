package com.bfchengnuo.factory;

import java.sql.ResultSet;

/**
 * Created by 冰封承諾Andy on 4/28/2017.
 * 操作数据库相关的接口
 * 临时随便写几个
 */
public interface UserDao {
    int add(String sql);
    int remove(String sql);
    int update(String sql);
    ResultSet query(String sql);
}
