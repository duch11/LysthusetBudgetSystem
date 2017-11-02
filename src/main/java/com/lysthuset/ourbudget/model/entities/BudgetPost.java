package com.lysthuset.ourbudget.model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BudgetPost {

    private int budgetPostID;
    private BigDecimal total;
    private String label;
    private ArrayList<User> payees;


    public BudgetPost(int budgetPostID, BigDecimal total, ArrayList<User> payees) {
        this.budgetPostID = budgetPostID;
        this.total = total;
        this.payees = payees;
    }

    public BigDecimal getShare() {
        BigDecimal share = total.divide(new BigDecimal(payees.size()));
        return share;
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
}
