package com.lysthuset.ourbudget.model.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BudgetPost {

    private int budgetPostID;
    private String description;
    private BudgetCategory category;
    private BigDecimal total;
    private ArrayList<User> payees;

    public BudgetPost(int budgetPostID, String description, BudgetCategory category,
        BigDecimal total, ArrayList<User> payees) {
        this.budgetPostID = budgetPostID;
        this.description = description;
        this.category = category;
        this.total = total;
        this.payees = payees;
    }

    public BigDecimal getShare() {
        BigDecimal share = new BigDecimal("0");
        if(payees.size() != 0){
            share = total.divide(new BigDecimal(payees.size()), 2, RoundingMode.HALF_UP);
        }

        return share;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getDescription() {
        return description;
    }

    public boolean isValidForUser(User user) {
        for(User payee : payees){
            if(payee.getUserID() == user.getUserID()){
                return true;
            }
        }
        //else not needed
        return false;
    }

    public BudgetCategory getCategory() {
        return category;
    }

    public ArrayList<User> getPayees(){
        return payees;
    }

    public BigDecimal calculateRemaining(ArrayList<Payment> payments){
        BigDecimal remaining = total;
        for(Payment payment : payments){
            for(PayLabel payLabel : category.getPayLabels()){
                if(payment.getPayLabel().equals(payLabel.getLabel())){
                    remaining = remaining.subtract(payment.getAmount());
                }
            }
        }
        return remaining;
    }

    public BigDecimal calculateTotalSpend(ArrayList<Payment> payments){
        BigDecimal total = new BigDecimal(0);
        for(Payment payment : payments){
            for(PayLabel payLabel : category.getPayLabels()){
                if(payment.getPayLabel().equals(payLabel.getLabel())){
                    total = total.subtract(payment.getAmount());
                }
            }
        }
        return total;
    }

    public boolean canHavePayments(){
        if(category.hasPayments()){
            return true;
        }
        return false;
    }
}

