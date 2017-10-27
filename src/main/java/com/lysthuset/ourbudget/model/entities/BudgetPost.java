package com.lysthuset.ourbudget.model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BudgetPost {

    private BigDecimal total;
    private ArrayList<User> payees;

    public BudgetPost(BigDecimal amount, ArrayList<User> payees) {
        this.total = amount;
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
