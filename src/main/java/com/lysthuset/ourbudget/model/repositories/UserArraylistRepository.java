package com.lysthuset.ourbudget.model.repositories;

import com.lysthuset.ourbudget.model.entities.User;

import java.util.ArrayList;

public class UserArraylistRepository implements IUserRepository {

    ArrayList<User> users = new ArrayList<>();

    public UserArraylistRepository(){
        users.add(new User("jonas","123"));
    }


    @Override
    public void create(User user) {
        users.add(user);
    }

    @Override
    public ArrayList<User> readAll() {
        return users;
    }

    @Override
    public User read(String id) {
        for (User u : users) {
            if(u.getUserID() == id){
                return u;
            }
        }
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(String id) {
        for (User u : users) {
            if(u.getUserID() == id){
                users.remove(u);
            }
        }
    }
}
