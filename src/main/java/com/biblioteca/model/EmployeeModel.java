package com.biblioteca.model;

public class EmployeeModel extends PersonModel {

    private String username;
    private String password;

    public EmployeeModel() {
        super();
    }

    public EmployeeModel(String nationalId, String names, String lastNames, String username, String password) {
        super(nationalId, names, lastNames);
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
