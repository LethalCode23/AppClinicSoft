package com.example.DentalClinicMVC.model;

import java.time.LocalDate;

public class Patient {

    private Integer patSec;
    private String patName;
    private String patLastName;
    private Integer patIdentity;
    private LocalDate patAdmission;
    private String patEmail;
    private Address address;

    public Patient(String patName, String patLastName, Integer patIdentity, LocalDate patAdmission, String patEmail, Address address) {
        this.patName = patName;
        this.patLastName = patLastName;
        this.patIdentity = patIdentity;
        this.patAdmission = patAdmission;
        this.patEmail = patEmail;
        this.address = address;
    }

    public Patient(Integer patSec, String patName, String patLastName, Integer patIdentity, LocalDate patAdmission, String patEmail, Address address) {
        this.patSec = patSec;
        this.patName = patName;
        this.patLastName = patLastName;
        this.patIdentity = patIdentity;
        this.patAdmission = patAdmission;
        this.patEmail = patEmail;
        this.address = address;
    }

    public Integer getPatSec() {
        return patSec;
    }

    public void setPatSec(Integer patSec) {
        this.patSec = patSec;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getPatLastName() {
        return patLastName;
    }

    public void setPatLastName(String patLastName) {
        this.patLastName = patLastName;
    }

    public Integer getPatIdentity() {
        return patIdentity;
    }

    public void setPatIdentity(Integer patIdentity) {
        this.patIdentity = patIdentity;
    }

    public LocalDate getPatAdmission() {
        return patAdmission;
    }

    public void setPatAdmission(LocalDate patAdmission) {
        this.patAdmission = patAdmission;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPatEmail() {
        return patEmail;
    }

    public void setPatEmail(String email) {
        this.patEmail = email;
    }
}