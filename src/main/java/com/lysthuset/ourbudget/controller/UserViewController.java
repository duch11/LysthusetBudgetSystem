package com.lysthuset.ourbudget.controller;

import com.lysthuset.ourbudget.model.entities.Payment;
import com.lysthuset.ourbudget.model.repositories.IPaymentRepository;
import com.lysthuset.ourbudget.model.repositories.IUserRepository;
import com.lysthuset.ourbudget.model.repositories.PaymentRepository;
import com.lysthuset.ourbudget.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserViewController {
    @Autowired
    IUserRepository usersRepo = new UserRepository();

    @Autowired
    IPaymentRepository paymentRepo = new PaymentRepository();

    @RequestMapping(value = "/userview", method = RequestMethod.GET)
    public String showUserview(Model model, @RequestParam("userID") int userID){
        model.addAttribute("users", usersRepo.readAll());
        model.addAttribute("user", usersRepo.read(userID));
        model.addAttribute("payments", paymentRepo.readPaymentsFor(usersRepo.read(1)));
        List<Payment> payments = paymentRepo.readPaymentsFor(usersRepo.read(1));
        return "userview";
    }

}
