package com.example.cyrent.Model;

public class DriverInfoModel {
   private String first_Name,last_Name,PhoneNumber,avatar;
   private double rating;

    public DriverInfoModel() {
    }


    public String getFirstName() {
        return first_Name;
    }

    public void setFirstName(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLastName() {
        return last_Name;
    }

    public void setLastName(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
