package com.demo.domain;

public class Location {
    private Long id;

    private String loaddress;

    private Long employeeid;

    private Long status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoaddress() {
        return loaddress;
    }

    public void setLoaddress(String loaddress) {
        this.loaddress = loaddress == null ? null : loaddress.trim();
    }

    public Long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Long employeeid) {
        this.employeeid = employeeid;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}