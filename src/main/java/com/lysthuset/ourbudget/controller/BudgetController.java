package com.lysthuset.ourbudget.controller;

import com.lysthuset.ourbudget.model.entities.Budget;
import com.lysthuset.ourbudget.model.entities.User;
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

import java.math.BigDecimal;
import java.util.ArrayList;

@Controller
public class BudgetController {
    @Autowired
    UserRepository usersRepo;

    @Autowired
    PaymentRepository paymentRepo;

    @Autowired
    MonthRepository monthRepo;

    @Autowired
    BudgetPostRepository budgetPostRepo;

    @Autowired
    BudgetBuilder builder;


    @Autowired
    HeaderHelper hHelper;

    private User currentUser;
    private Budget budget;

    @RequestMapping(value = {"/", "","/overview"}, method = RequestMethod.GET)
    public String showOverview(Model model){
        budget = builder.makeCurrentBudget();
        model.addAttribute("usersWithRent", budget.getUsers());
        model.addAttribute("budget", budget);
        model.addAttribute("budgetpostswithpayments", budget.getBudgetPostsWithPayments());

        model.addAttribute("month",budget.getMonth() + " " + budget.getYear());
        hHelper.showHeaderOverview(model);
        model.addAttribute("overblik", true);
        return "overview";
    }

    @RequestMapping(value = "/userview", method = RequestMethod.GET)
    public String showUserviewCurrent(Model model, @RequestParam("userID") int userID){

        currentUser = hHelper.showHeaderFor(model, userID);

        budget = builder.makeCurrentBudget();


        TimeHelper time = new TimeHelper();
        model.addAttribute("nextmonth",  time.getMonth(1) + " " + time.getYear(1));
        model.addAttribute("rent", budget.calculateRentFor(currentUser));
        model.addAttribute("month",budget.getMonth() + " " + budget.getYear());
        model.addAttribute("payments", budget.getPaymentsFor(currentUser));
        model.addAttribute("categories", budget.getPaymentCategories());

        return "userview";
    }

    @RequestMapping(value = "/userview/addpayment", method = RequestMethod.POST)
    public String addPayment(Model model,
                          @RequestParam("userID") int userID,
                          @RequestParam("password") String password,
                          @RequestParam("description") String description,
                          @RequestParam("paymentcategoryID") int paymentcategoryID,
                          @RequestParam("amount") String amount){
        System.out.println(userID + " " + password + " " + description + " " + paymentcategoryID + " " + amount);

        return showUserviewCurrent(model, new Integer(userID));
    }

    @RequestMapping(value = "/userview/month", method = RequestMethod.GET)
    public String showUserviewForDate(Model model, @RequestParam("userID") int userID, @RequestParam("month") String month, @RequestParam("year") int year){
        hHelper.showHeader(model);


        model.addAttribute("rent", 12);
        model.addAttribute("payments", paymentRepo.readPaymentsFor(usersRepo.read(userID)));
        return "userview";
    }


    @RequestMapping(value = "/budgetview", method = RequestMethod.GET)
    public String showBudgetCurrent(Model model){

        hHelper.showHeader(model);
        budget = builder.makeCurrentBudget();

        model.addAttribute("month",budget.getMonth() + " " + budget.getYear());
        model.addAttribute("budgetposts", budget.getBudgetPosts());
        model.addAttribute("total", budget.getBudgetedTotal());
        return "budgetview";
    }

    @RequestMapping(value = "/budgetview/month", method = RequestMethod.GET)
    public String showBudgetForMonth(Model model){


        return "budgetview";
    }




}
