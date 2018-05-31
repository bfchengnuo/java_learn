package com.bfchengnuo.action;

import com.bfchengnuo.po.Page;
import com.bfchengnuo.po.Student;
import com.bfchengnuo.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/5/28.
 */
public class StudentAction extends ActionSupport {
    private StudentService studentService = new StudentService();

    private Student student;
    private List<Student> list;

    private int pageNumber = 1;
    private Page<Student> page;

    public String addStudent() {
        if (student != null) {
            studentService.addStudent(student);
            return SUCCESS;
        }
        return ERROR;
    }

    public String delStudent() {
        if (student != null && student.getId() != null) {
            studentService.deleteStudent(student);
            return SUCCESS;
        }
        return ERROR;
    }

    public String updateStudent() {
        if (student != null) {
            studentService.update(student);
            return SUCCESS;
        }
        return ERROR;
    }

    public String queryStudent() {
        if (student != null && student.getId() != null) {
            this.student = studentService.queryStudentById(this.student.getId());
            return SUCCESS;
        }
        return ERROR;
    }

    public String queryAll() {
        list = studentService.queryAllStudent();
        if (list != null)
            return SUCCESS;
        return ERROR;
    }

    public String querySome() {
        page = new Page<>();
        if (student == null) {
            student = new Student();
        }

        page.setPageNumber(pageNumber);
        int total = studentService.getCount(student.getName(),student.getAge());
        page.setTotal(total);

        List<Student> list = studentService.queryStudentSome(page.getStart(), page.getPageSize(), student.getName(), student.getAge());
        page.setRows(list);

        return SUCCESS;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Page<Student> getPage() {
        return page;
    }

}
