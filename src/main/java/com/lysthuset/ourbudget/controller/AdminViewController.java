package com.lysthuset.ourbudget.controller;

import org.springframework.stereotype.Controller;

@Controller
public class AdminViewController {
    public String showAdminView(){

        return "adminview";
    }
}
