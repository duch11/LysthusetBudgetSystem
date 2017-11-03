package com.lysthuset.ourbudget.model.repositories;

public interface IMonthRepository {
    int getMonthID(int year, String month);

    Boolean createMonth(int year, String month);


}
