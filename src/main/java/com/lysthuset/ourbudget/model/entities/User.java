package com.lysthuset.ourbudget.model.entities;

import java.util.UUID;

public class User {
    private String userID;
    private String name;
    private String pass;
    private boolean active;
    private boolean admin = false;

    public User(){
        this.userID = UUID.randomUUID().toString();
        this.active = true;

    }

    //admin dummy tester NAVN PASS
    public User(String name, String pass) {
        this.userID = UUID.randomUUID().toString();
        this.name = name;
        this.pass = pass;
        this.active = true;
    }

    public User(String name, String pass, boolean active, boolean admin) {
        this.userID = UUID.randomUUID().toString();
        this.name = name;
        this.pass = pass;
        this.active = active;
        this.admin = admin;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isAdmin() {
        return admin;
    }
}
