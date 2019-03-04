package com.ssmdemo.dao.entity;


import org.springframework.stereotype.Component;

@Component

public class DoctorEntity {

    private String docid;
    private String name;
    private String gender;
    private String department;
    private String address;
    private Double docLat;
    private Double docLng;
    private String startTime;
    private String endTime;
    private String phoneNumber;
    private String language;

    public DoctorEntity(){

    }

    public DoctorEntity(String docid, String name, String gender, String department, String address, Double docLat, Double docLng, String startTime, String endTime, String phoneNumber, String language) {
        this.docid = docid;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.address = address;
        this.docLat = docLat;
        this.docLng = docLng;
        this.startTime = startTime;
        this.endTime = endTime;
        this.phoneNumber = phoneNumber;
        this.language = language;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getDocLat() {
        return docLat;
    }

    public void setDoclat(Double docLat) {
        this.docLat = docLat;
    }

    public Double getDocLng() {
        return docLng;
    }

    public void setDocLng(Double docLng) {
        this.docLng = docLng;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}