package com.lysthuset.ourbudget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BudgetViewController {

    @RequestMapping(value = "/budgetview", method = RequestMethod.GET)
    public String budgetview(){
        return "budgetview";
    }
}
