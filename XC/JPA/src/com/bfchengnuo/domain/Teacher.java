package com.bfchengnuo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 冰封承諾Andy on 2017/8/20.
 *
 * 多对多的示例
 * 作为关系的被维护端，无权修改、更新外键
 */
@Entity
public class Teacher {
    private Integer id;
    private String name;
    private Set<Student> students = new HashSet<>();

    public Teacher() {
    }

    public Teacher(String name) {
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

    // 在多对多的关系中，一般不会设置级联删除，太危险
    @ManyToMany(cascade = CascadeType.REFRESH,mappedBy = "teachers")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    // 相同的 ID 即认为是相同的对象

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        return id != null ? id.equals(teacher.id) : teacher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
