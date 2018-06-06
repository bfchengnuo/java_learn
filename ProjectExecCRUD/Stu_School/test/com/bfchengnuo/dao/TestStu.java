package com.bfchengnuo.dao;

import com.bfchengnuo.po.School;
import com.bfchengnuo.po.Student;

import java.util.Date;

/**
 * Created by 冰封承諾Andy on 2018/6/5.
 */
public class TestStu {
    public static void main(String[] args) {
        StuDao dao = new StuDaoImpl();

        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setName("Loli" + i);
            student.setAge(6 + i);
            student.setBirth(new Date());
            student.setEmail("abc@yousa.tech");
            School sc = new School();
            sc.setId((int)(Math.random() * 4) + 1 );
            student.setSchool(sc);

            dao.addStu(student);
        }
    }
}
