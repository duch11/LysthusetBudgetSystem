package com.lysthuset.ourbudget.model.utilities;

import com.lysthuset.ourbudget.model.entities.Budget;
import com.lysthuset.ourbudget.model.entities.BudgetPost;
import com.lysthuset.ourbudget.model.entities.Payment;
import com.lysthuset.ourbudget.model.repositories.BudgetPostRepository;
import com.lysthuset.ourbudget.model.repositories.MonthRepository;
import com.lysthuset.ourbudget.model.repositories.PaymentRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BudgetBuilder {

    private MonthRepository monthRepo;

    private BudgetPostRepository budgetPostRepo;

    private PaymentRepository paymentRepo;

    public BudgetBuilder(MonthRepository monthRepo, PaymentRepository paymentRepo, BudgetPostRepository budgetPostRepo) {
        this.paymentRepo = paymentRepo;
        this.monthRepo = monthRepo;
        this.budgetPostRepo = budgetPostRepo;
    }

    public Budget makeBudgetOffset(int offset) {
        TimeHelper time = new TimeHelper();
        int year = time.getYear(offset);
        String month = time.getMonth(offset);

        int monthID = this.monthRepo.getMonthID(year, month);
        System.out.println("makeBudgetOffset Called! monthID: " + monthID + " ");
        ArrayList<Payment> payments = this.paymentRepo.readPaymentsForMonth(monthID);
        ArrayList<BudgetPost> budgetPosts = this.budgetPostRepo.readBudgetPostsForMonth(monthID);

        return new Budget(monthID, month, year, budgetPosts, payments);

    }

    public Budget makeCurrentBudget(){
        return makeBudgetOffset(0);
    }
}
