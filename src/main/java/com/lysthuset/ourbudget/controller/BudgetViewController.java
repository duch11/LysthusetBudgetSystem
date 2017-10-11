package com.lysthuset.ourbudget.controller;

import com.lysthuset.ourbudget.model.repositories.IUserRepository;
import com.lysthuset.ourbudget.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BudgetViewController {

    @Autowired
    IUserRepository usersRepo = new UserRepository();

    @RequestMapping(value = "/budgetview", method = RequestMethod.GET)
    public String budgetview(Model model){
        model.addAttribute("users",usersRepo.readAll());
        return "budgetview";
    }
}
