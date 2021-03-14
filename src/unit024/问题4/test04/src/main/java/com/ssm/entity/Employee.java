package com.ssm.entity;

import com.ssm.dao.DepartmentDao;

import java.util.Date;

/**
 * 员工实体
 */
public class Employee {
    private Integer empId;
    private String empName;
    private Integer deptId;
    private String jobName;
    private Date joinDate;
    private String telephone;
    private Department department;

    public Employee() {
    }

    public Employee(Integer empId, String empName, Integer deptId, String jobName, Date joinDate, String telephone) {
        this.empId = empId;
        this.empName = empName;
        this.deptId = deptId;
        this.jobName = jobName;
        this.joinDate = joinDate;
        this.telephone = telephone;
    }

    public Employee(String empName, Integer deptId, String jobName, Date joinDate, String telephone) {
        this.empName = empName;
        this.deptId = deptId;
        this.jobName = jobName;
        this.joinDate = joinDate;
        this.telephone = telephone;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", deptId=" + deptId +
                ", jobName='" + jobName + '\'' +
                ", joinDate=" + joinDate +
                ", telephone='" + telephone + '\'' +
                ", department=" + department +
                '}';
    }
}
