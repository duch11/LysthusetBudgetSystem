package com.lysthuset.ourbudget.model.entities;

import java.math.BigDecimal;

public class Payment {
    private int ID;
    private int userID;
    private int monthID;
    private BigDecimal amount;
    private String description;
    private String category;

    public Payment(int ID, String category, int userID, int monthID, BigDecimal amount, String description) {
        this.ID = ID;
        this.category = category;
        this.userID = userID;
        this.monthID = monthID;
        this.amount = amount;
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}
