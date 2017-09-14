package com.lysthuset.ourbudget.model.repositories;

import com.lysthuset.ourbudget.model.entities.User;

import java.util.ArrayList;

public interface IUserRepository {
    //create
    public void create(User user);

    //read
    public ArrayList<User> readAll();

    //read specific
    public User read(String id);

    //
    public void update(User user);

    public void delete(String id);
}
