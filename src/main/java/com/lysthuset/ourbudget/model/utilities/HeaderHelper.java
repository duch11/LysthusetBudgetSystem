package com.lysthuset.ourbudget.model.utilities;

import com.lysthuset.ourbudget.model.entities.User;
import com.lysthuset.ourbudget.model.repositories.IUserRepository;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;


@Component
public class HeaderHelper {

    IUserRepository usersRepo;

    public HeaderHelper(IUserRepository usersRepo) {
        this.usersRepo = usersRepo;
    }

    public User showHeaderFor(Model model, int userID){
        model.addAttribute("users", usersRepo.readAll());
        model.addAttribute("currentUser", usersRepo.read(userID));
        return usersRepo.read(userID);
    }

    public User showHeader(Model model){
        return showHeaderFor(model, -1);
    }
}
