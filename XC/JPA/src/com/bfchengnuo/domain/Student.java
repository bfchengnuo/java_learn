package com.bfchengnuo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 冰封承諾Andy on 2017/8/20.
 *
 * 多对多的示例
 * 作为关系的维护端，有权修改、更新外键
 */
@Entity
public class Student {
    private Integer id;
    private String name;
    private Set<Teacher> teachers = new HashSet<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // inverseJoinColumns 即关系被维护端的外键列名
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "student_teacher",inverseJoinColumns = @JoinColumn(name = "teacher_id"),
            joinColumns = @JoinColumn(name = "student_id"))
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
