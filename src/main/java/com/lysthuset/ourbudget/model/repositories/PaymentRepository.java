package com.lysthuset.ourbudget.model.repositories;

import com.lysthuset.ourbudget.model.entities.Payment;
import com.lysthuset.ourbudget.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository implements IPaymentRepository {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Payment> readPaymentsFor(User user) {
        List<Payment> paymentsForUser = new ArrayList<Payment>();

        //Joiner payments og paymentlabels på deres FK og ID Finder en bestemt brugers payments (ikke måned specifik)
        //TODO: tilføj måned parameter
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM payments INNER JOIN paymentlabels ON FK_PayLabel_ID=PaymentLabel_ID WHERE FK_user_ID=" + user.getUserID());
        while (sqlRowSet.next()) {
            paymentsForUser.add(
                    new Payment(
                            sqlRowSet.getInt("Payment_ID"),
                            sqlRowSet.getString("label"),
                            sqlRowSet.getInt("FK_user_ID"),
                            sqlRowSet.getInt("FK_month_ID"),
                            sqlRowSet.getBigDecimal("amount"),
                            sqlRowSet.getString("description")
                    )
            );

            //TEST Console CODE
            int id = sqlRowSet.getInt("Payment_ID");
            String desc = sqlRowSet.getString("description");
            BigDecimal amount = sqlRowSet.getBigDecimal("amount");
            System.out.println(id + " " + desc + " " + amount + " " + sqlRowSet.getString("label"));
        }
        return paymentsForUser;
    }

    @Override
    public ArrayList<Payment> readAll() {
        return null;
    }

    @Override
    public ArrayList<Payment> readPaymentsForMonth(int monthID) {

        List<Payment> paymentsForMonth = new ArrayList<Payment>();

        //Joiner payments og paymentlabels på deres FK og ID Finder en bestemt brugers payments (ikke måned specifik)
        //TODO: tilføj måned parameter
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM payments INNER JOIN paymentlabels ON FK_PayLabel_ID=PaymentLabel_ID WHERE FK_month_ID=" + monthID);
        while (sqlRowSet.next()) {
            paymentsForMonth.add(
                    new Payment(
                            sqlRowSet.getInt("Payment_ID"),
                            sqlRowSet.getString("label"),
                            sqlRowSet.getInt("FK_user_ID"),
                            sqlRowSet.getInt("FK_month_ID"),
                            sqlRowSet.getBigDecimal("amount"),
                            sqlRowSet.getString("description")
                    )
            );

        }
        System.out.println("readPaymentsForMonth called!");
        return (ArrayList<Payment>) paymentsForMonth;
    }
}