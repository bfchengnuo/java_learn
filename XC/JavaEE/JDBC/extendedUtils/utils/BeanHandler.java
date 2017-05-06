package com.bfchengnuo.jdbc.utils;

import com.bfchengnuo.jdbc.SimpleTab;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * 默认的 handler 实现，实现 rs 中的数据拷贝到 bean 中
 * 对应的是单条记录
 */
public class BeanHandler implements ResultSetHandler {
    private Class<SimpleTab> clazz;

    public BeanHandler(Class<SimpleTab> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object handler(ResultSet rs) {
        try {
            if (rs == null || !rs.next()) {
                return null;
            }
            Object bean = clazz.newInstance();
            // 得到结果集的元数据
            ResultSetMetaData metaData = rs.getMetaData();
            int count = metaData.getColumnCount();
            for (int i = 0; i < count; i++) {
                // 获取每一列的名字
                String name = metaData.getColumnName(i + 1);
                // 获取每一列的值
                Object value = rs.getObject(name);

                // 利用反射技术得到相应的属性，使数据拷贝到 javabean 里
                Field field = bean.getClass().getDeclaredField(name);
                field.setAccessible(true);
                field.set(bean, value);
            }
            return bean;
        } catch (InstantiationException | IllegalAccessException | SQLException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }
}
