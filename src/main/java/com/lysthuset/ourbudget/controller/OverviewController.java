package com.lysthuset.ourbudget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OverviewController {


    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String showOverview(){
        return "overview";
    }

}
