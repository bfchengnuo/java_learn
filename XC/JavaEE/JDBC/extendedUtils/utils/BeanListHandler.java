package com.bfchengnuo.jdbc.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 默认的 handler 实现，实现 rs 中的数据全部拷贝到 bean 中
 * 返回一个 List
 */
public class BeanListHandler implements ResultSetHandler {
    private Class clazz;

    public BeanListHandler(Class clazz) {
        this.clazz = clazz;
    }


    @Override
    public Object handler(ResultSet rs) {
        List<Object> mList = new ArrayList<>();
        try {
            while (rs.next()) {
                Object bean = clazz.newInstance();
                ResultSetMetaData metaData = rs.getMetaData();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String name = metaData.getColumnName(i + 1);
                    Object value = rs.getObject(name);

                    // 反射，使用 Declared 说明获取的是已声明字段
                    Field field = bean.getClass().getDeclaredField(name);
                    field.setAccessible(true); // 暴力访问
                    field.set(bean, value);
                }
                mList.add(bean);
            }
            return mList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
