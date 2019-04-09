package com.demo.domain;

public class Department {

    private Long deid;

    private String department;

    private Long managerid;

    public Long getDeid() {
        return deid;
    }

    public void setDeid(Long deid) {
        this.deid = deid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Long getManagerid() {
        return managerid;
    }

    public void setManagerid(Long managerid) {
        this.managerid = managerid;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deid=" + deid +
                ", department='" + department + '\'' +
                ", managerid=" + managerid +
                '}';
    }
}