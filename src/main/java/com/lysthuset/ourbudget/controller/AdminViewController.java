package com.lysthuset.ourbudget.controller;

import com.lysthuset.ourbudget.model.entities.User;
import com.lysthuset.ourbudget.model.repositories.IUserRepository;
import com.lysthuset.ourbudget.model.repositories.UserArraylistRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Controller
public class AdminViewController {

    private IUserRepository usersRepo = new UserArraylistRepository();
    private ArrayList<User> usersArray = usersRepo.readAll();

    @RequestMapping(value = {"/adminpanel"}, method = RequestMethod.GET)
    public String adminpanel(Model model){
        model.addAttribute("users", usersArray);
        model.addAttribute("user", new User());

        return "adminview";
    }

    //OVERVEJ th:object og at bruge en User object som parameter i stedet for at lave et selv
    @RequestMapping(value = {"/adduser"}, method = RequestMethod.POST)
    public String addUser(Model model,
                          @ModelAttribute User myUser)
    {

        if(myUser.getName() != "" && myUser.getPass() != "" && myUser.getPass() != null){
            System.out.println("her er værdierne: " + myUser.getName() + " " + myUser.getPass());

            usersRepo.create(myUser);
            usersArray = usersRepo.readAll();

        }

        model.addAttribute("users", usersArray);
        return "adminview";
    }

    /*      ===============
            = DELETE USER =
            ===============        */
    @RequestMapping(value = {"/deleteuser"}, method = RequestMethod.POST)
    public String deleteuser(Model model,
                             @RequestParam(value = "deleteid") String id) {
        usersArray.remove(id);
        model.addAttribute("users", usersArray);
        System.out.println("Delete function called");
        return "adminpanel";
    }
}
