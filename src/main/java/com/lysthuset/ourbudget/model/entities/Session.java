package com.lysthuset.ourbudget.model.entities;

public class Session {
    private User loggedInUser;

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    // Kig på noget modellering tak
    public void logOut(){
        loggedInUser = null;
    }
}
