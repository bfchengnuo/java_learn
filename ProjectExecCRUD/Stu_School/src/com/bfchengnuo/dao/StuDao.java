package com.bfchengnuo.dao;

import com.bfchengnuo.po.Student;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/6/5.
 */
public interface StuDao {
    void addStu(Student student);

    void delStuById(int id);

    void updateStu(Student student);

    Student queryStuById(int id);

    List<Student> querySome(String name,Integer sid, int start, int max);

    int countStu(String name, Integer sid);
}
