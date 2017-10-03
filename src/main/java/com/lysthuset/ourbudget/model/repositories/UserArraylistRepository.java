package com.lysthuset.ourbudget.model.repositories;

import com.lysthuset.ourbudget.model.entities.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserArraylistRepository implements IUserRepository {

    List<User> users = new ArrayList<>();


/*
    public UserArraylistRepository(){
        users.add(new User(1,"Jonas","123", true, true));
        users.add(new User(2,"Stine","123", true, true));
        users.add(new User(3,"Røde","123", true, true));
        users.add(new User(4,"Marie","123", true, true));
        users.add(new User(5,"Michael","123", true, true));
        users.add(new User(6,"Tine","123", true, true));
    }
*/


    @Override
    public void create(User user) {
        users.add(user);
    }

    @Override
    public List<User> readAll() {
        return users;
    }

    @Override
    public User read(int id) {
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
    public void delete(int id) {
        for (Iterator<User> userIterator = users.iterator(); userIterator.hasNext();) {
            User userCompare = userIterator.next();
            if(userCompare.getUserID() == id){
                userIterator.remove();
                System.out.println("user: " + userCompare.getName() + " deleted.");
            } else {
                System.out.println("no deletion");
            }
        }
    }
}
