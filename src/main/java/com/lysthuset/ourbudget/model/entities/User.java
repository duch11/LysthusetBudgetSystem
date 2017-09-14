package com.lysthuset.ourbudget.model.entities;

import java.lang.management.BufferPoolMXBean;
import java.util.UUID;

public class User {
    private String userID;
    private String name;

    private String pass;

    private Boolean admin;
    private Boolean budgetBoss;
    private Boolean active;
    public User(){

    }

    //admin dummy tester
    public User(String name, String pass) {
        this.userID = userID;
        this.name = name;
        this.pass = pass;
        this.admin = true;
        this.budgetBoss = false;
        this.active = false;
    }

    public User(String userID, String name, String pass) {
        this.userID = userID;
        this.name = name;
        this.pass = pass;
        this.admin = false;
        this.budgetBoss = false;
        this.active = false;
    }

    public User(String userID, String name, String pass, Boolean admin, Boolean budgetBoss, Boolean active){
        this.userID = userID;
        this.name = name;
        this.pass = pass;
        this.admin = admin;
        this.budgetBoss = budgetBoss;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getBudgetBoss() {
        return budgetBoss;
    }

    public void setBudgetBoss(Boolean budgetBoss) {
        this.budgetBoss = budgetBoss;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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


}
