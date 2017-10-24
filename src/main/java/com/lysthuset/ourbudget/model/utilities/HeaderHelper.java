package com.lysthuset.ourbudget.model.utilities;

import com.lysthuset.ourbudget.model.repositories.IUserRepository;
import org.springframework.ui.Model;

public class HeaderHelper {
    public void showHeader(Model model, IUserRepository usersRepo, int userID){
        model.addAttribute("users", usersRepo.readAll());
        model.addAttribute("currentUser", usersRepo.read(userID));
    }
}
