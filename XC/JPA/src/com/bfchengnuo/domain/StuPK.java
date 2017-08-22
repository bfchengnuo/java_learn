package com.bfchengnuo.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by 冰封承諾Andy on 2017/8/21.
 * stu 的联合主键类，一般以 PK 结尾
 * 根据班级号和学号才能确定一个学生
 *
 * 注意要重写 hashCode...，以及序列化
 */
@Embeddable
public class StuPK implements Serializable {
    private Integer classId;
    private Integer stuId;

    public StuPK() {
    }

    public StuPK(Integer classId, Integer stuId) {
        this.classId = classId;
        this.stuId = stuId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuPK stuPK = (StuPK) o;

        if (classId != null ? !classId.equals(stuPK.classId) : stuPK.classId != null) return false;
        return stuId != null ? stuId.equals(stuPK.stuId) : stuPK.stuId == null;
    }

    @Override
    public int hashCode() {
        int result = classId != null ? classId.hashCode() : 0;
        result = 31 * result + (stuId != null ? stuId.hashCode() : 0);
        return result;
    }
}
