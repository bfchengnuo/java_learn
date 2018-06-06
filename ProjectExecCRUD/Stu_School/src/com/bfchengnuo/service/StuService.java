package com.bfchengnuo.service;

import com.bfchengnuo.dao.StuDao;
import com.bfchengnuo.dao.StuDaoImpl;
import com.bfchengnuo.po.Student;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/6/5.
 */
public class StuService {
    private StuDao dao = new StuDaoImpl();

    public void addStu(Student student) {
        dao.addStu(student);
    }

    public void delStuById(int id) {
        dao.delStuById(id);
    }


    public void updateStu(Student student) {
        dao.updateStu(student);
    }

    public Student queryStuById(int id) {
        return dao.queryStuById(id);
    }


    public List<Student> querySome(String name,Integer sid, int start, int max) {
        return dao.querySome(name,sid, start, max);
    }

    public int countStu(String name, Integer sid) {
        return dao.countStu(name, sid);
    }
}
