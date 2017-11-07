package com.lysthuset.ourbudget.model.entities;

import java.math.BigDecimal;
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
            share = total.divide(new BigDecimal(payees.size()));
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
}
