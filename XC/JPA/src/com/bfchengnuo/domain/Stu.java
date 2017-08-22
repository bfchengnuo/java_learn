package com.bfchengnuo.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by 冰封承諾Andy on 2017/8/21.
 * 使用联合主键
 */
@Entity
public class Stu {
    private StuPK id;
    private String name;

    public Stu() {
    }

    public Stu(String name,Integer classId, Integer stuId) {
        this.name = name;
        id = new StuPK(classId, stuId);
    }

    @EmbeddedId
    public StuPK getId() {
        return id;
    }

    public void setId(StuPK id) {
        this.id = id;
    }

    @Column(length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
