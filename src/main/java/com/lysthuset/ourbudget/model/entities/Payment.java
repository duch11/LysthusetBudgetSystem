package com.lysthuset.ourbudget.model.entities;

import java.math.BigDecimal;

public class Payment {
    private int ID;
    private int userID;
    private int monthID;
    private BigDecimal amount;
    private String description;
    private String payLabel;

    public Payment(int ID, String payLabel, int userID, int monthID, BigDecimal amount, String description) {
        this.ID = ID;
        this.payLabel = payLabel;
        this.userID = userID;
        this.monthID = monthID;
        this.amount = amount;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getMonthID() {
        return monthID;
    }

    public void setMonthID(int monthID) {
        this.monthID = monthID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPayLabel() {
        return payLabel;
    }

    public void setPayLabel(String payLabel) {
        this.payLabel = payLabel;
    }
}
