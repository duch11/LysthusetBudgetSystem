package com.lysthuset.ourbudget.model.repositories;

import com.lysthuset.ourbudget.model.entities.BudgetPost;

import java.util.ArrayList;

public interface IBudgetPostRepository {


    ArrayList<BudgetPost> readAll();

    ArrayList<BudgetPost> readBudgetPostsForMonth(int monthID);
}
