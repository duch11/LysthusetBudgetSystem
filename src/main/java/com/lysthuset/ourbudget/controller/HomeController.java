package com.lysthuset.ourbudget.controller;
import com.lysthuset.ourbudget.model.entities.User;
import com.lysthuset.ourbudget.model.repositories.IUserRepository;
import com.lysthuset.ourbudget.model.repositories.UserArraylistRepository;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;


@Controller
public class HomeController {
    private ArrayList<User> usersArray = new ArrayList<>();
    IUserRepository userRepo = new UserArraylistRepository();

    /*@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute User userToLogin){

        return "hej";
    }*/

}