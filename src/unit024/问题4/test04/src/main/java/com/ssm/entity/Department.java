package com.ssm.entity;

/**
 * 部门实体
 */
public class Department {
    private Integer deptId;
    private String deptName;
    private String majorName;
    private String telephone;
    private String email;

    public Department() {
    }

    public Department(Integer deptId, String deptName, String majorName, String telephone, String email) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.majorName = majorName;
        this.telephone = telephone;
        this.email = email;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
