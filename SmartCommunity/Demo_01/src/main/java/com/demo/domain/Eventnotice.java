package com.demo.domain;

public class Eventnotice {
    private Long id;

    private String eventname;

    private Long managetypeid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname == null ? null : eventname.trim();
    }

    public Long getManagetypeid() {
        return managetypeid;
    }

    public void setManagetypeid(Long managetypeid) {
        this.managetypeid = managetypeid;
    }
}