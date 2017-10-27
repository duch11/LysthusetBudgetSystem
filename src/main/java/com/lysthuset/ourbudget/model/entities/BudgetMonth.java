package com.lysthuset.ourbudget.model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BudgetMonth {
    private ArrayList<BudgetPost> budgetPosts;
    private ArrayList<Payment> payments;

    public BudgetMonth(ArrayList<BudgetPost> budgetPosts, ArrayList<Payment> payments) {
        this.budgetPosts = budgetPosts;
        this.payments = payments;
    }

    public BigDecimal calculateRentFor(User user){
        BigDecimal rent = new BigDecimal(0);
        for (BudgetPost budgetPost : budgetPosts) {
            if(budgetPost.isValidForUser(user)){
                rent.add(budgetPost.getShare());
            }
        }

        for (Payment payment : payments){
            if(payment.getUserID() == user.getUserID()){
                rent.subtract(payment.getAmount());
            }
        }
        return rent;
    }
}
