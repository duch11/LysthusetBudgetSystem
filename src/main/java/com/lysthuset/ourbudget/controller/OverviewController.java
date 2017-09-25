package com.lysthuset.ourbudget.controller;

import org.springframework.stereotype.Controller;

@Controller
public class OverviewController {
    public String showOverview(){

        return "overview";
    }
}
