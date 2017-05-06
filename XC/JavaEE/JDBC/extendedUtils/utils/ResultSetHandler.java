package com.bfchengnuo.jdbc.utils;

import java.sql.ResultSet;

/**
 * Created by 冰封承諾Andy on 5/5/2017.
 * 具体实现 rs 的处理的接口，用户可以实现或者用默认已经实现好的
 */
public interface ResultSetHandler {
    Object handler(ResultSet rs);
}
