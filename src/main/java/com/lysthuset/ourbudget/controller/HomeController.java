package com.lysthuset.ourbudget.controller;


import com.lysthuset.ourbudget.model.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Controller
public class HomeController {
    private ArrayList<User> usersArray = new ArrayList<>();

    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("users", usersArray);
        return "adminpanel";
    }

    //OVERVEJ th:object og at bruge en User object som parameter i stedet for at lave et selv
    @RequestMapping(value = {"/adduser"}, method = RequestMethod.POST)
    public String addUser(Model model,
            @RequestParam(value = "navn") String navn,
            @RequestParam(value = "pass") String pass)
    {
        System.out.println("her er værdierne: " + navn + " " + pass);
        if(navn != "" && pass != ""){

            usersArray.add(new User(usersArray.size(), navn, pass));

            Collections.sort(usersArray,
                new Comparator<User>() {
                    @Override
                    public int compare(User user1, User user2) {
                        return user1.getName().compareTo(user2.getName());
                    }
                }
            );

        }


        model.addAttribute("users", usersArray);
        System.out.println("hej med dig postman");
        return "adminpanel";
    }

    @RequestMapping(value = {"/deleteuser"}, method = RequestMethod.POST)
    public String deleteuser(Model model,
                             @RequestParam(value = "deleteid") int id) {
        usersArray.remove(id);
        model.addAttribute("users", usersArray);
        System.out.println("Delete function called");
        return "adminpanel";
    }

}