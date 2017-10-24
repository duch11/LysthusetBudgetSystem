package com.lysthuset.ourbudget.controller;

import com.lysthuset.ourbudget.model.repositories.IUserRepository;
import com.lysthuset.ourbudget.model.repositories.UserRepository;
import com.lysthuset.ourbudget.model.utilities.HeaderHelper;
import com.sun.xml.internal.ws.server.sei.MessageFiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OverviewController {

    @Autowired
    IUserRepository usersRepo = new UserRepository();


    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String showOverview(Model model){
        new HeaderHelper().showHeader(model, usersRepo, -2);
        return "overview";
    }

}
