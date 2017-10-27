package com.lysthuset.ourbudget.controller;

import com.lysthuset.ourbudget.model.entities.BudgetMonth;
import com.lysthuset.ourbudget.model.entities.BudgetPost;
import com.lysthuset.ourbudget.model.entities.Payment;
import com.lysthuset.ourbudget.model.repositories.*;
import com.lysthuset.ourbudget.model.utilities.HeaderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserViewController {
    @Autowired
    IUserRepository usersRepo = new UserRepository();

    @Autowired
    IPaymentRepository paymentRepo = new PaymentRepository();

    HeaderHelper helper = new HeaderHelper();

    @RequestMapping(value = "/userview", method = RequestMethod.GET)
    public String showUserview(Model model, @RequestParam("userID") int userID){
        helper.showHeader(model, usersRepo, userID);


        BudgetMonth budget = new BudgetMonth();

        model.addAttribute("payments", paymentRepo.readPaymentsFor(usersRepo.read(userID)));
        return "userview";
    }

}
