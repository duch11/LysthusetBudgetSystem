package com.lysthuset.ourbudget.model.repositories;

import com.lysthuset.ourbudget.model.entities.User;

import java.util.List;

public interface IUserRepository {
    //create
    public void create(User user);

    //read
    public List<User> readAll();

    //read specific
    public User read(int id);

    //
    public void update(User user);

    public void delete(int id);
}
