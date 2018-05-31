package com.bfchengnuo.dao;

import com.bfchengnuo.factory.Factory;
import com.bfchengnuo.po.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by 冰封承諾Andy on 2018/5/28.
 */
public class StudentDaoImpl implements StudentDao {
    private QueryRunner qr = new QueryRunner(Factory.getDs());

    @Override
    public void addStudent(Student stu) {
        String sql = "insert into student(name,age,birth) values(?,?,?)";
        try {
            qr.update(sql, stu.getName(), stu.getAge(), stu.getBirth());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student queryStudentById(int id) {
        String sql = "select * from student where id=?";
        try {
            return qr.query(sql, new BeanHandler<>(Student.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> queryAllStudent() {
        String sql = "select * from student";
        try {
            return qr.query(sql, new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount(String name, Integer age) {
        String sql = "select count(*) count from student where 1=1";
        if (name != null && !name.equals("")) {
            sql += " and name like '%" + name + "%'";
        }
        if (age != null) {
            sql += " and age=" + age;
        }

        try {
            Map<String, Object> map = qr.query(sql, new MapHandler());
            return Integer.parseInt(map.get("count").toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Student> queryStudentSome(Integer start, Integer max, String name, Integer age) {
        String sql = "select * from student where 1=1";

        if (name != null && !name.equals("")) {
            sql += " and name like '%" + name + "%'";
        }
        if (age != null) {
            sql += " and age=" + age;
        }

        sql += " limit ?,?";
        try {
            return qr.query(sql, new BeanListHandler<>(Student.class),start,max);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Student stu) {
        String sql = "update student set name=?,age=?,birth=? where id=?";
        try {
            qr.update(sql, stu.getName(), stu.getAge(), stu.getBirth(), stu.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(Student stu) {
        String sql = "delete from student where id=?";
        try {
            qr.update(sql, stu.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
