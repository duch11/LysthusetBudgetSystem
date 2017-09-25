package com.lysthuset.ourbudget.model.entities;

import java.lang.management.BufferPoolMXBean;
import java.util.UUID;

public class User {
    private String userID;
    private String name;
    private String pass;

    public User(){}

    //admin dummy tester NAVN PASS
    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
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


}
