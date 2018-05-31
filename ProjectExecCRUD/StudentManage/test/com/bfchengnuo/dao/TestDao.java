package com.bfchengnuo.dao;

import com.bfchengnuo.po.Student;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/5/28.
 */
public class TestDao {
    static StudentDao dao = new StudentDaoImpl();

    public static void main(String[] args) {
        Student stu = new Student();
        stu.setName("Loli");
        stu.setAge(12);
        stu.setBirth(new Date());

        dao.addStudent(stu);
    }

    @Test
    public void queryTest(){
        Student student = dao.queryStudentById(1);
        System.out.println(student);
    }

    @Test
    public void queryAllTest(){
        List<Student> list = dao.queryAllStudent();
        list.forEach(System.out::println);
    }

    @Test
    public void updateTest() {
        Student student = dao.queryStudentById(1);
        student.setAge(15);
        dao.update(student);

        // queryTest();
    }

    @Test
    public void querySomeCountTest(){
        int count = dao.getCount(null, null);
        System.out.println(count);
    }

    @Test
    public void querySomeTest() {
        List<Student> studentList = dao.queryStudentSome(0, 2, "li", null);
        studentList.forEach(System.out::println);
    }

}
