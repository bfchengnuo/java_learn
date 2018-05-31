package com.bfchengnuo.action;

import com.bfchengnuo.po.Employee;
import com.bfchengnuo.po.Organization;
import com.bfchengnuo.po.Page;
import com.bfchengnuo.service.EmpService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/5/30.
 */
public class EmpAction extends ActionSupport {
    private EmpService empService = new EmpService();

    private String name;
    private Integer pageNumber;
    private Page<Employee> page;
    private int[] id;

    private List<Organization> organs;

    public String queryEmps() throws Exception {
        if (pageNumber == 0) {
            pageNumber = 1;
        }
        page = new Page<>();
        page.setPageNumber(pageNumber);
        Integer total = empService.querySomeCount(name);
        page.setTotal(total);

        List<Employee> list = empService.querySomeEmp(name, page.getStart(), page.getPageSize());
        page.setRows(list);

        return SUCCESS;
    }

    public String delEmp() throws Exception {
        for (int i : id) {
            empService.delEmp(new Employee(i));
        }
        return SUCCESS;
    }


    public String getOrgan() throws Exception {
        organs = empService.queryAllOrgan();
        return SUCCESS;
    }

    public Page<Employee> getPage() {
        return page;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }


    public List<Organization> getOrgans() {
        return organs;
    }

    public void setId(int[] id) {
        this.id = id;
    }
}
