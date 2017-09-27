package com.lysthuset.ourbudget.model.repositories;

import com.lysthuset.ourbudget.model.entities.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserArraylistRepository implements IUserRepository {

    List<User> users = new ArrayList<User>();


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
    public List<User> readAll() {
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
        for (Iterator<User> userIterator = users.iterator(); userIterator.hasNext();) {
            User userCompare = userIterator.next();
            if(userCompare.getUserID().equals(id)){
                userIterator.remove();
                System.out.println("user: " + userCompare.getName() + " deleted.");
            } else {
                System.out.println("no deletion");
            }
        }
    }
}
