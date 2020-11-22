package com.volvo.SpringBootApplication.model;

public class Info {
    public String msidn;
    public String engineStatus;
    public String fleet;
    public String brand;
    public String countryOfOperation;
    public int chassisNumber;
    public String chassisSeries;

    public Info(String msidn, String engineStatus, String fleet, String brand, String countryOfOperation, int chassisNumber, String chassisSeries){
        this.msidn = msidn;
        this.engineStatus = engineStatus;
        this.fleet = fleet;
        this.brand = brand;
        this.countryOfOperation = countryOfOperation;
        this.chassisNumber = chassisNumber;
        this.chassisSeries = chassisSeries;
    }
}
