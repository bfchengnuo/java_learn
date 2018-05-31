package com.bechengnuo.test.dao;

import com.bfchengnuo.dao.EmpDao;
import com.bfchengnuo.dao.EmpDaoImpl;
import com.bfchengnuo.po.Employee;
import com.bfchengnuo.po.Organization;
import org.junit.Test;

/**
 * Created by 冰封承諾Andy on 2018/5/30.
 */
public class TestEmpDao {
    private EmpDao<Employee> dao = new EmpDaoImpl<>();

    @Test
    public void addTest() {
        Employee e = new Employee();
        e.setEmpName("员工1");
        e.setAge(12);
        e.setEmpCode("1231546123");
        e.setSex("男");
        e.setOrganizationByOrgaId(new Organization(3));
        dao.add(e);
    }

    @Test
    public void getEmpTest() {
        Employee employee = dao.queryById(Employee.class, 1);
        System.out.println(employee.getEmpName() + "\t" + employee.getAge() + "\t" + employee.getSex());
    }

    @Test
    public void getCountTest() {
        Integer integer = dao.querySomeCount(Employee.class, null);
        System.out.println(integer);
    }
}
