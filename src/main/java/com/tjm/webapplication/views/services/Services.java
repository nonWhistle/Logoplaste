package com.tjm.webapplication.views.services;

import java.util.Date;

public class Services {

    private String machine;
    private String service;
    private Date date;

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getService() {
        return service;
    }

    public void setService(String client) {
        this.service = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
