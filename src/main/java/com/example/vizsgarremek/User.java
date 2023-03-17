package com.example.vizsgarremek;

public class User {
    private String user;
    private String passwrod;

    public User(String user, String passwrod) {
        this.user = user;
        this.passwrod = passwrod;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }
}
