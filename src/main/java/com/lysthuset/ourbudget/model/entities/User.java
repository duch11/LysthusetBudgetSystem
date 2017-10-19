package com.lysthuset.ourbudget.model.entities;


public class User {
    private int userID;
    private String name;
    private String pass;
    private boolean active;
    private boolean admin = false;

    public User(){
    }

    public User(int userID ,String name, String pass, boolean active, boolean admin) {

        this.userID = userID;
        this.name = name;
        this.pass = pass;
        this.active = active;
        this.admin = admin;
    }


    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
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
