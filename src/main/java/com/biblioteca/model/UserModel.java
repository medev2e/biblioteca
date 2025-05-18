package com.biblioteca.model;

public class UserModel extends PersonModel {

    private String address;
    private long phoneNumber;
    private String email;

    public UserModel() {
        super();
    }

    public UserModel(String nationalId, String names, String lastNames, String address, long phoneNumber,
            String email) {
        super(nationalId, names, lastNames);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
