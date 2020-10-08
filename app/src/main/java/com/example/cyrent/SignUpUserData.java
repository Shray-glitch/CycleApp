package com.example.cyrent;

public class SignUpUserData {
    String email;
    String password;
    String fullName;
    String Phone_number;


    public SignUpUserData(String email, String password, String fullName, String phone_number) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        Phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }
}
