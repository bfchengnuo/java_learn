package com.bfchengnuo.po;

import org.apache.struts2.json.annotations.JSON;

import java.util.Collection;

/**
 * Created by 冰封承諾Andy on 2018/5/30.
 */
public class Organization {
    private int orgaId;
    private String orgaName;
    private Integer parentId;
    private Collection<Employee> employeesByOrgaId;

    public Organization() {
    }

    public Organization(int orgaId) {
        this.orgaId = orgaId;
    }

    public int getOrgaId() {
        return orgaId;
    }

    public void setOrgaId(int orgaId) {
        this.orgaId = orgaId;
    }

    public String getOrgaName() {
        return orgaName;
    }

    public void setOrgaName(String orgaName) {
        this.orgaName = orgaName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (orgaId != that.orgaId) return false;
        if (orgaName != null ? !orgaName.equals(that.orgaName) : that.orgaName != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orgaId;
        result = 31 * result + (orgaName != null ? orgaName.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        return result;
    }

    @JSON(serialize=false)
    public Collection<Employee> getEmployeesByOrgaId() {
        return employeesByOrgaId;
    }

    public void setEmployeesByOrgaId(Collection<Employee> employeesByOrgaId) {
        this.employeesByOrgaId = employeesByOrgaId;
    }
}
