package com.bfchengnuo.action;

import com.bfchengnuo.po.Flag;
import com.bfchengnuo.po.Page;
import com.bfchengnuo.po.Student;
import com.bfchengnuo.service.StuService;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/6/5.
 */
public class StuAction {
    private StuService stuService = new StuService();

    private Page<Student> page;
    private String name;
    private Student stu;
    private Integer id;
    private Integer sid;

    private Flag flag;

    public String addStu() {
        if (stu != null) {
            stuService.addStu(stu);
        }
        return "add_suc";
    }

    public String delStu() {
        if (id != null) {
            stuService.delStuById(id);
        }
        flag.setFlag("suc");
        return "del_suc";
    }

    public String querySome() {
        int total = stuService.countStu(name,sid);
        page.setTotal(total);
        List<Student> list = stuService.querySome(name, sid, page.getStart(), page.getPageSize());
        page.setRows(list);

        return "querySome_suc";
    }

    public Page<Student> getPage() {
        return page;
    }

    public void setPage(Page<Student> page) {
        this.page = page;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
