package com.example.DentalClinicMVC.model;

public class Dentist {

    private Integer denSec;
    private Integer denRegistration;
    private String denName;
    private String denLastName;

    public Dentist(Integer denRegistration, String denName, String denLastName) {
        this.denRegistration = denRegistration;
        this.denName = denName;
        this.denLastName = denLastName;
    }

    public Dentist(Integer denSec, Integer denRegistration, String denName, String denLastName) {
        this.denSec = denSec;
        this.denRegistration = denRegistration;
        this.denName = denName;
        this.denLastName = denLastName;
    }

    public Integer getDenSec() {
        return denSec;
    }

    public void setDenSec(Integer denSec) {
        this.denSec = denSec;
    }

    public Integer getDenRegistration() {
        return denRegistration;
    }

    public void setDenRegistration(Integer denRegistration) {
        this.denRegistration = denRegistration;
    }

    public String getDenName() {
        return denName;
    }

    public void setDenName(String denName) {
        this.denName = denName;
    }

    public String getDenLastName() {
        return denLastName;
    }

    public void setDenLastName(String denLastName) {
        this.denLastName = denLastName;
    }
}