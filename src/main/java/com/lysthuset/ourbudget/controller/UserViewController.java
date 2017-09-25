package com.lysthuset.ourbudget.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UserViewController {

    public String getUserview(){

        return "userView";
    }
}
