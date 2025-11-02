package com.example.DentalClinicMVC.model;

public class Address {

    private Integer addSec;
    private String addStreet;
    private Integer addNumber;
    private String addLocation;
    private String addProvince;

    public Address(String addStreet, Integer addNumber, String addLocation, String addProvince) {
        this.addStreet = addStreet;
        this.addNumber = addNumber;
        this.addLocation = addLocation;
        this.addProvince = addProvince;
    }

    public Address(Integer addSec, String addStreet, Integer addNumber, String addLocation, String addProvince) {
        this.addSec = addSec;
        this.addStreet = addStreet;
        this.addNumber = addNumber;
        this.addLocation = addLocation;
        this.addProvince = addProvince;
    }

    public Integer getAddSec() {
        return addSec;
    }

    public void setAddSec(Integer addSec) {
        this.addSec = addSec;
    }

    public String getAddStreet() {
        return addStreet;
    }

    public void setAddStreet(String addStreet) {
        this.addStreet = addStreet;
    }

    public Integer getAddNumber() {
        return addNumber;
    }

    public void setAddNumber(Integer addNumber) {
        this.addNumber = addNumber;
    }

    public String getAddLocation() {
        return addLocation;
    }

    public void setAddLocation(String addLocation) {
        this.addLocation = addLocation;
    }

    public String getAddProvince() {
        return addProvince;
    }

    public void setAddProvince(String addProvince) {
        this.addProvince = addProvince;
    }
}