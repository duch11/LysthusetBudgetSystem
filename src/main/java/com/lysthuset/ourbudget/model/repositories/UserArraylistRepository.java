package com.lysthuset.ourbudget.model.repositories;

import com.lysthuset.ourbudget.model.entities.User;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.UUID;

public class UserArraylistRepository implements IUserRepository {

    ArrayList<User> users = new ArrayList<>();


    public UserArraylistRepository(){
        users.add(new User("Jonas","123", true, true));
        users.add(new User("Stine","123"));
        users.add(new User("Røde","123"));
        users.add(new User("Marie","123"));
        users.add(new User("Michael","123"));
        users.add(new User("Tine","123"));
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
        int i = users.indexOf(read(user.getUserID()));
        if(i != -1){
            users.add(i, user);
        }
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
