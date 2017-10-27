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

        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM payments INNER JOIN label_paymentcategory ON label_paymentcategory.ID=payments.labelID WHERE userID=" + user.getUserID());
        while(sqlRowSet.next()){
            paymentsForUser.add(
                    new Payment(
                            sqlRowSet.getInt("ID"),
                            sqlRowSet.getString("label"),
                            sqlRowSet.getInt("userID"),
                            sqlRowSet.getInt("FK_month_ID"),
                            sqlRowSet.getBigDecimal("amount"),
                            sqlRowSet.getString("description")
                    )
            );


            int id = sqlRowSet.getInt("ID");
            String desc =  sqlRowSet.getString("description");
            BigDecimal amount =  sqlRowSet.getBigDecimal("amount");
            System.out.println(id + " " + desc + " " + amount + " " + sqlRowSet.getString("category_name"));
        }
        return paymentsForUser;
    }
}
