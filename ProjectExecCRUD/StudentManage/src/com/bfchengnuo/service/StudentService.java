package com.bfchengnuo.service;

import com.bfchengnuo.dao.StudentDao;
import com.bfchengnuo.dao.StudentDaoImpl;
import com.bfchengnuo.po.Student;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/5/28.
 */
public class StudentService {
    private StudentDao dao = new StudentDaoImpl();

    public void addStudent(Student stu) {
        dao.addStudent(stu);
    }

    public Student queryStudentById(int id) {
        return dao.queryStudentById(id);
    }

    public List<Student> queryAllStudent() {
        return dao.queryAllStudent();
    }

    public void update(Student stu) {
        dao.update(stu);
    }

    public void deleteStudent(Student stu) {
        dao.deleteStudent(stu);
    }

    public List<Student> queryStudentSome(Integer start, Integer max, String name, Integer age) {
        return dao.queryStudentSome(start, max, name, age);
    }

    public int getCount(String name, Integer age) {
        return dao.getCount(name, age);
    }
}
