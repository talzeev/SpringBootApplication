package com.volvo.SpringBootApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Vehicle {
    private String id;
    private String name;
    private Info info;
    private Service[] services;

    public Vehicle(String id, String name, Info info){
        this.id = id;
        this.name = name;
        this.info = info;
    }

    //Setters & Getters
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
