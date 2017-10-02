package com.lysthuset.ourbudget.controller;

import com.lysthuset.ourbudget.model.entities.User;
import com.lysthuset.ourbudget.model.repositories.IUserRepository;
import com.lysthuset.ourbudget.model.repositories.UserArraylistRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class AdminViewController {

    private IUserRepository usersRepo = new UserArraylistRepository();
    private List<User> usersArray = usersRepo.readAll();

    @RequestMapping(value = {"/adminpanel", "/deleteuser", "/adduser"}, method = RequestMethod.GET)
    public String adminpanel(Model model){
        model.addAttribute("users", usersArray);
        model.addAttribute("user", new User());
        return "adminview";
    }


    @RequestMapping(value = {"/adduser"}, method = RequestMethod.POST)
    public String addUser(Model model, @ModelAttribute User myUser) {
        if(myUser.getName() != "" && myUser.getPass() != "" && myUser.getPass() != null){
            System.out.println("her er værdierne: " + myUser.getName() + " " + myUser.getPass());
            usersRepo.create(myUser);
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
