package com.lysthuset.ourbudget.model.entities;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Budget {
    private int monthID;
    private String month;
    private int year;
    private ArrayList<BudgetPost> budgetPosts;
    private ArrayList<Payment> payments;

    public Budget(int monthID, String month, int year, ArrayList<BudgetPost> budgetPosts, ArrayList<Payment> payments) {
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
                rent = rent.add(budgetPost.getShare());
            }
        }

        for (Payment payment : payments) {
            if (payment.getUserID() == user.getUserID()) {
                rent = rent.subtract(payment.getAmount());
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

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<PayLabel> getPaymentCategories(){
        ArrayList<PayLabel> payLabels = new ArrayList<>();

        for(BudgetPost bp : budgetPosts){
            ArrayList<PayLabel> payLabelsForBP = bp.getCategory().getPayLabels();
            if(!payLabelsForBP.isEmpty()){
                for (PayLabel p : payLabelsForBP){
                    payLabels.add(p);
                }
            }
        }

        return payLabels;
    }

    public ArrayList<BudgetPost> getBudgetPosts() {
        return budgetPosts;
    }

    public BigDecimal getBudgetedTotal(){
        BigDecimal bTotal = new BigDecimal("0");
        for(BudgetPost bp : budgetPosts){
            bTotal = bTotal.add(bp.getTotal());
        }
        return bTotal;
    }
}