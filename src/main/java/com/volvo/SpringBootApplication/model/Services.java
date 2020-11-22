package com.volvo.SpringBootApplication.model;

public class Services {
    private String communicationStatus;
    private Service[] services;

    public Services(String communicationStatus, Service[] services) {
        this.communicationStatus = communicationStatus;
        this.services = services;
    }

    public String getCommunicationStatus() {
        return communicationStatus;
    }

    public void setCommunicationStatus(String communicationStatus) {
        this.communicationStatus = communicationStatus;
    }

    public Service[] getServices() {
        return services;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }
}
