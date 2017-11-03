package com.lysthuset.ourbudget.model.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;


@Repository
public class MonthRepository implements IMonthRepository {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int getMonthID(int year, String month){
        int monthID = -1;

        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM months WHERE month='" + month +"' AND year=" + year);

        if(sqlRowSet.next()){
            monthID = sqlRowSet.getInt("month_ID");
            System.out.println("Month found!");

        } else {
            System.out.println("Month not found!");
        }
        System.out.println("GetMonthID Called!");


        return monthID;
    }

    /*@Override
    public Budget getBudgetFor(int year, String month) {

        //get monthID Based on provided month and year
        int ID = getMonthID(year, month);

        //get payments
        SqlRowSet sqlRowSet = jdbc.queryForRowSet(
                "SELECT * FROM payments "
                        + "INNER JOIN "
                        + " paymentlabels ON "
                        + " WHERE year="  + month +" AND year=" + year);

        ArrayList<Payment> payments =


        return budget;
    }*/


    @Override
    public Boolean createMonth(int year, String month) {

        jdbc.update("INSERT INTO months (month, year) VALUES ('"+ month +"', " + year + ")" );

        return null;
    }


}
