package com.lysthuset.ourbudget.model.utilities;

import com.lysthuset.ourbudget.model.entities.Budget;
import com.lysthuset.ourbudget.model.entities.BudgetPost;
import com.lysthuset.ourbudget.model.entities.Payment;
import com.lysthuset.ourbudget.model.repositories.IBudgetPostRepository;
import com.lysthuset.ourbudget.model.repositories.IMonthRepository;
import com.lysthuset.ourbudget.model.repositories.IPaymentRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BudgetBuilder {

    private IMonthRepository monthRepo;

    private IBudgetPostRepository budgetPostRepo;

    private IPaymentRepository paymentRepo;

    public BudgetBuilder(IMonthRepository monthRepo, IPaymentRepository paymentRepo, IBudgetPostRepository budgetPostRepo) {
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
