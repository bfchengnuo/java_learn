package com.bfchengnuo.dao;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/5/30.
 */
public interface EmpDao<T> {
    void add(T emp);

    void del(T emp);

    void delEmpById(int id);

    void update(T emp);

    T queryById(Class<T> cls, Integer id);

    List<T> queryAll(Class<T> cls);

    List<T> querySome(Class<T> cls, String name, int start, int max);

    Integer querySomeCount(Class<T> cls, String name);
}
