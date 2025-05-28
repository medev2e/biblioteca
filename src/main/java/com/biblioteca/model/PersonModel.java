package com.biblioteca.model;

public class PersonModel {

    private String nationalId;
    private String names;
    private String lastNames;

    public PersonModel() {

    }

    public PersonModel(String nationalId,
            String names,
            String lastNames) {

        this.nationalId = nationalId;
        this.names = names;
        this.lastNames = lastNames;

    }

    public String getNationalId() {

        return nationalId;

    }

    public void setNationalId(String nationalId) {

        this.nationalId = nationalId;

    }

    public String getNames() {

        return names;

    }

    public void setNames(String names) {

        this.names = names;

    }

    public String getLastNames() {

        return lastNames;

    }

    public void setLastNames(String lastNames) {

        this.lastNames = lastNames;

    }

}
