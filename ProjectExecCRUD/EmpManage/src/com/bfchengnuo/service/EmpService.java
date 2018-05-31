package com.bfchengnuo.service;

import com.bfchengnuo.dao.EmpDao;
import com.bfchengnuo.dao.EmpDaoImpl;
import com.bfchengnuo.po.Employee;
import com.bfchengnuo.po.Organization;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/5/30.
 */
public class EmpService {
    EmpDao<Employee> empDao = new EmpDaoImpl<>();
    EmpDao<Organization> organDao = new EmpDaoImpl<>();

    public void addEmp(Employee employee) {
        empDao.add(employee);
    }

    public void addOrgan(Organization organization) {
        organDao.add(organization);
    }

    public void delEmp(Employee employee) {
        empDao.delEmpById(employee.getEmpId());
    }

    public void delOrgan(Organization organization) {
        organDao.del(organization);
    }

    public void updateEmp(Employee employee) {
        empDao.update(employee);
    }

    public void updateOrgan(Organization organization) {
        organDao.update(organization);
    }

    public List<Employee> queryAllEmp() {
        return empDao.queryAll(Employee.class);
    }

    public Employee queryEmpById(Integer id) {
        return empDao.queryById(Employee.class, id);
    }

    public List<Employee> querySomeEmp(String name, int start, int max) {
        return empDao.querySome(Employee.class, name, start, max);
    }

    public Integer querySomeCount(String name) {
        return empDao.querySomeCount(Employee.class, name);
    }

    public List<Organization> queryAllOrgan() {
        return organDao.queryAll(Organization.class);
    }



}
