package com.lysthuset.ourbudget.controller;

import com.lysthuset.ourbudget.model.entities.BudgetMonth;
import com.lysthuset.ourbudget.model.repositories.*;
import com.lysthuset.ourbudget.model.utilities.BudgetBuilder;
import com.lysthuset.ourbudget.model.utilities.HeaderHelper;
import com.lysthuset.ourbudget.model.utilities.TimeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserViewController {
    @Autowired
    IUserRepository usersRepo;

    @Autowired
    IPaymentRepository paymentRepo;

    @Autowired
    IMonthRepository monthRepo;

    @Autowired
    IBudgetPostRepository budgetPostRepo;

    private HeaderHelper hHelper = new HeaderHelper();
    private TimeHelper time = new TimeHelper();


    BudgetMonth budget;

    @RequestMapping(value = "/userview", method = RequestMethod.GET)
    public String showUserviewCurrentDate(Model model, @RequestParam("userID") int userID){

        hHelper.showHeader(model, usersRepo, userID);

        //TODO: Make this actually work (NULL POINTER EXCEPTION)
        budget = new BudgetBuilder(monthRepo, paymentRepo, budgetPostRepo).makeBudgetFor(time.getYear(0), time.getMonth(0));


        model.addAttribute("rent", 12);
        model.addAttribute("payments", paymentRepo.readPaymentsFor(usersRepo.read(userID)));
        return "userview";
    }

    @RequestMapping(value = "/userview/month", method = RequestMethod.GET)
    public String showUserviewForDate(Model model, @RequestParam("userID") int userID, @RequestParam("month") String month, @RequestParam("year") int year){
        hHelper.showHeader(model, usersRepo, userID);


        model.addAttribute("rent", 12);
        model.addAttribute("payments", paymentRepo.readPaymentsFor(usersRepo.read(userID)));
        return "userview";
    }


}
