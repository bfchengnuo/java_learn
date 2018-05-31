package com.bfchengnuo.action;

import com.bfchengnuo.po.Employee;
import com.bfchengnuo.po.Organization;
import com.bfchengnuo.service.EmpService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 冰封承諾Andy on 2018/5/30.
 */
public class UpdateAction extends ActionSupport {
    private EmpService empService = new EmpService();

    private Employee employee;
    private String orga;
    private int pageNumber;

    private int id;


    public String addEmp() throws Exception {
        Organization organization = new Organization();
        organization.setOrgaId(Integer.parseInt(orga));
        employee.setOrganizationByOrgaId(organization);
        empService.addEmp(employee);

        return SUCCESS;
    }

    public String updateEmp() throws Exception {
        Organization organization = new Organization();
        organization.setOrgaId(Integer.parseInt(orga));
        employee.setOrganizationByOrgaId(organization);
        empService.updateEmp(employee);
        return "success";
    }

    public String toUpdateEmp() throws Exception {
        employee = empService.queryEmpById(id);
        orga = String.valueOf(employee.getOrganizationByOrgaId().getOrgaId());
        return "success";
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setOrga(String orga) {
        this.orga = orga;
    }

    public String getOrga() {
        return orga;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
