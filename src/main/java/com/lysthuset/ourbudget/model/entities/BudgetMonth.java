package com.lysthuset.ourbudget.model.entities;
import java.math.BigDecimal;
import java.util.ArrayList;

public class BudgetMonth {
    private int monthID;
    private String month;
    private int year;
    private ArrayList<BudgetPost> budgetPosts;
    private ArrayList<Payment> payments;

    public BudgetMonth(int monthID, String month, int year, ArrayList<BudgetPost> budgetPosts, ArrayList<Payment> payments) {
        this.monthID = monthID;
        this.month = month;
        this.year = year;
        this.budgetPosts = budgetPosts;
        this.payments = payments;
    }

    public BigDecimal calculateRentFor(User user) {
        BigDecimal rent = new BigDecimal(0);
        for (BudgetPost budgetPost : budgetPosts) {
            if (budgetPost.isValidForUser(user)) {
                rent.add(budgetPost.getShare());
            }
        }

        for (Payment payment : payments) {
            if (payment.getUserID() == user.getUserID()) {
                rent.subtract(payment.getAmount());
            }
        }
        return rent;
    }

    public ArrayList<Payment> getPaymentsFor(User user) {
        ArrayList<Payment> userPayments = new ArrayList<>();
        for (Payment payment : payments) {
            if (payment.getUserID() == user.getUserID()) {
                userPayments.add(payment);
            }
        }
        return userPayments;
    }
}