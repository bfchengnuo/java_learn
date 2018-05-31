package com.bfchengnuo.dao;


import com.bfchengnuo.po.Student;

import java.util.List;

/**
 * @author Kerronex
 * @version 创建时间：2018年5月23日 下午4:21:50
 */
public interface StudentDao {
    void addStudent(Student stu);

    Student queryStudentById(int id);

    List<Student> queryAllStudent();

    int getCount(String name, Integer age);

    List<Student> queryStudentSome(Integer start, Integer max, String name, Integer age);


    void update(Student stu);

    void deleteStudent(Student stu);
}
