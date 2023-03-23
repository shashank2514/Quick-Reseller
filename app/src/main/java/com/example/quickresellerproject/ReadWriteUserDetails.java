package com.example.quickresellerproject;

public class ReadWriteUserDetails {
    public String name,age,mobile,gender;
    public boolean admin;

    public ReadWriteUserDetails(String name, String age, String mobile, String gender,boolean admin) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.gender = gender;
        this.admin=admin;
    }
}


