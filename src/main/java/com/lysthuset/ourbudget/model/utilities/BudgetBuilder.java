package com.lysthuset.ourbudget.model.utilities;

import com.lysthuset.ourbudget.model.entities.BudgetMonth;
import com.lysthuset.ourbudget.model.entities.BudgetPost;
import com.lysthuset.ourbudget.model.entities.Payment;
import com.lysthuset.ourbudget.model.repositories.IBudgetPostRepository;
import com.lysthuset.ourbudget.model.repositories.IMonthRepository;
import com.lysthuset.ourbudget.model.repositories.IPaymentRepository;
import com.lysthuset.ourbudget.model.repositories.IUserRepository;
import java.util.ArrayList;

public class BudgetBuilder {

    private IMonthRepository monthRepo;

    private IBudgetPostRepository budgetPostRepo;

    private IPaymentRepository paymentRepo;

    public BudgetBuilder(IMonthRepository monthRepo, IPaymentRepository paymentRepo, IBudgetPostRepository budgetPostRepo) {
        this.paymentRepo = paymentRepo;
        this.monthRepo = monthRepo;
        this.budgetPostRepo = budgetPostRepo;
    }

    public BudgetMonth makeBudgetFor(int year, String month) {

        int monthID = this.monthRepo.getMonthID(year, month);
        ArrayList<Payment> payments = this.paymentRepo.readPaymentsForMonth(monthID);
        ArrayList<BudgetPost> budgetPosts = this.budgetPostRepo.readBudgetPostsForMonth(monthID);

        return new BudgetMonth(12, month, year, budgetPosts, payments);

    }
}
