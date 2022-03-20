package com.example.examplemvvmapplication.model;

public class UserModel {
    private String fullName;
    private String city;
    private String phone;

    public UserModel() {
    }

    public UserModel(String fullName, String city, String phone) {
        this.fullName = fullName;
        this.city = city;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "fullName='" + fullName + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
