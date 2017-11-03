package com.lysthuset.ourbudget.model.entities;

import java.util.ArrayList;

public class BudgetCategory {
    int ID;
    String label;
    ArrayList<PayLabel> paymentCategories;

    public BudgetCategory(int ID, String label, ArrayList<PayLabel> paymentCategories) {
        this.ID = ID;
        this.label = label;
        this.paymentCategories = paymentCategories;
    }

    public int getID() {
        return ID;
    }

    public String getLabel() {
        return label;
    }

    public ArrayList<PayLabel> getPayLabels() {
        return paymentCategories;
    }
}
