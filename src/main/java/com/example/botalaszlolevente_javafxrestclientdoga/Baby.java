package com.example.botalaszlolevente_javafxrestclientdoga;

import com.google.gson.annotations.Expose;

public class Baby {
    private int id;
    @Expose
    private String name;
    @Expose
    private String gender;
    @Expose
    private Integer hospital;
    @Expose
    private String birthDate;

    public Baby(int id, String name, String gender, Integer hospital, String level) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.hospital = hospital;
        this.birthDate = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getHospital() {
        return hospital;
    }

    public void setHospital(Integer hospital) {
        this.hospital = hospital;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
