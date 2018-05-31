package com.bfchengnuo.po;

/**
 * Created by 冰封承諾Andy on 2018/5/30.
 */
public class Employee {
    private int empId;
    private String empName;
    private String empCode;
    private String sex;
    private Integer age;
    private Organization organizationByOrgaId;

    public Employee() {
    }

    public Employee(int empId) {
        this.empId = empId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (empId != employee.empId) return false;
        if (empName != null ? !empName.equals(employee.empName) : employee.empName != null) return false;
        if (empCode != null ? !empCode.equals(employee.empCode) : employee.empCode != null) return false;
        if (sex != null ? !sex.equals(employee.sex) : employee.sex != null) return false;
        if (age != null ? !age.equals(employee.age) : employee.age != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empId;
        result = 31 * result + (empName != null ? empName.hashCode() : 0);
        result = 31 * result + (empCode != null ? empCode.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    public Organization getOrganizationByOrgaId() {
        return organizationByOrgaId;
    }

    public void setOrganizationByOrgaId(Organization organizationByOrgaId) {
        this.organizationByOrgaId = organizationByOrgaId;
    }
}
