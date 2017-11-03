package com.lysthuset.ourbudget.model.entities;

public class PayLabel {
    int ID;
    String label;

    public PayLabel(int ID, String label) {
        this.ID = ID;
        this.label = label;
    }

    public int getID() {
        return ID;
    }

    public String getLabel() {
        return label;
    }
}
