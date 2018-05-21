package com.francisco.mundialapp.data;


public class User {
    String name;
    String lastname;
    String identification;
    String password;

    public User() {
    }

    public User(String name, String lastname, String identification, String password) {
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
