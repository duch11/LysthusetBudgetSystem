package com.lysthuset.ourbudget.controller;



import com.lysthuset.ourbudget.model.entities.User;
import com.lysthuset.ourbudget.model.repositories.IUserRepository;
import com.lysthuset.ourbudget.model.repositories.UserArraylistRepository;
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
    IUserRepository userRepo = new UserArraylistRepository();


    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute(new User());
        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute User userToLogin){

        return "hej";
    }

    @RequestMapping(value = {"/adminpanel"}, method = RequestMethod.GET)
    public String adminpanel(Model model){
        model.addAttribute("users", usersArray);
        model.addAttribute("user", new User());

        return "welcome";
    }

    //OVERVEJ th:object og at bruge en User object som parameter i stedet for at lave et selv
    @RequestMapping(value = {"/adduser"}, method = RequestMethod.POST)
    public String addUser(Model model,
            @ModelAttribute User myUser)
    {
        System.out.println("her er værdierne: " + myUser.getName() + " " + myUser.getPass());

        if(myUser.getName() != "" && myUser.getPass() != "" && myUser.getPass() != null){

            usersArray.add(myUser);

            Collections.sort(usersArray,
                new Comparator<User>() {
                    @Override
                    public int compare(User user1, User user2) {
                        return user1.getName().compareTo(user2.getName());
                    }
                }
            );

        }

        //opdater/overskriv array (tror jeg den gør)
        model.addAttribute("users", usersArray);
        return "adminpanel";
    }

    @RequestMapping(value = {"/deleteuser"}, method = RequestMethod.POST)
    public String deleteuser(Model model,
                             @RequestParam(value = "deleteid") String id) {
        usersArray.remove(id);
        model.addAttribute("users", usersArray);
        System.out.println("Delete function called");
        return "adminpanel";
    }

}