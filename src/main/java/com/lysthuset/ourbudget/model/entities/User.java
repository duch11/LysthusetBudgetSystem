package com.lysthuset.ourbudget.model.entities;

public class User {
    private int userID;

    private String name;
    private String pass;
    private Boolean admin;
    private Boolean budgetBoss;
    private Boolean active;
    public User(int userID, String name, String pass) {
        this.userID = userID;
        this.name = name;
        this.pass = pass;
        admin = false;
        budgetBoss = false;
        active = false;
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

    public int getUserID() {
        return userID;
    }


}
