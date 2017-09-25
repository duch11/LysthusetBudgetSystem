package com.lysthuset.ourbudget.controller;

import org.springframework.stereotype.Controller;

@Controller
public class BudgetViewController {
    public String showBudgetView(){

        return "budgetview";
    }
}
