package com.lysthuset.ourbudget.controller;

import com.lysthuset.ourbudget.model.entities.Budget;
import com.lysthuset.ourbudget.model.entities.User;
import com.lysthuset.ourbudget.model.repositories.UserRepository;
import com.lysthuset.ourbudget.model.utilities.BudgetBuilder;
import com.lysthuset.ourbudget.model.utilities.HeaderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminViewController {

    @Autowired
    UserRepository usersRepo = new UserRepository();

    List<User> usersArray;

    @Autowired
    HeaderHelper helper;

    @Autowired
    BudgetBuilder builder;

    private Budget budget;

    @RequestMapping(value = {"/adminpanel", "/deleteuser", "/adduser", "/edituser", "/error"}, method = RequestMethod.GET)
    public String adminpanel(Model model){
        usersArray = usersRepo.readAll();
        budget = builder.makeCurrentBudget();
        model.addAttribute("users", usersArray);
        model.addAttribute("useredit", new User());
        helper.showHeader(model);
        model.addAttribute("useradd", new User());

        model.addAttribute("month",budget.getMonth() + " " + budget.getYear());
        return "adminview";
    }


    @RequestMapping(value = {"/adduser"}, method = RequestMethod.POST)
    public String addUser(Model model, @ModelAttribute User myUser) {
        if(myUser.getName() != "" && myUser.getPass() != "" && myUser.getPass() != null){
            System.out.println("her er værdierne: " + myUser.getName() + " " + myUser.getPass() +" " + myUser.isActive() + " " + myUser.isAdmin());
            usersRepo.create(myUser);
            usersArray = usersRepo.readAll();
        }
        return adminpanel(model);
    }

    @RequestMapping(value = {"/edituser"}, method = RequestMethod.POST)
    public String editUser(Model model, @ModelAttribute User myUser) {
        if(myUser.getName() != "" && myUser.getPass() != "" && myUser.getPass() != null){
            usersRepo.update(myUser);
            usersArray = usersRepo.readAll();
        }
        return adminpanel(model);
    }

    /*      ===============
            = DELETE USER =
            ===============        */

    @RequestMapping(value = {"/deleteuser"}, method = RequestMethod.POST)
    public String deleteusers(Model model,
                             @RequestParam(value = "deleteid") int id) {
        usersRepo.delete(id);
        usersArray = usersRepo.readAll();
        System.out.println("Delete function called");

        return adminpanel(model);
    }
}
