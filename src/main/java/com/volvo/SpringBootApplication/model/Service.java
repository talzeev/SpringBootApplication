package com.volvo.SpringBootApplication.model;

import java.util.Date;

public class Service {
    private String serviceName;
    private String status;
    private Date lastUpdate;

    public Service(String serviceName, String status, Date lastUpdate) {
        this.serviceName = serviceName;
        this.status = status;
        this.lastUpdate = lastUpdate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
