package com.lysthuset.ourbudget.model.repositories;

import com.lysthuset.ourbudget.model.entities.BudgetMonth;

public interface IMonthRepository {
    int getMonthID(int year, String month);

    Boolean createMonth(int year, String month);


}
