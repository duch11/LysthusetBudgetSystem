package com.lysthuset.ourbudget.model.repositories;

import com.lysthuset.ourbudget.model.entities.Payment;
import com.lysthuset.ourbudget.model.entities.User;

import java.util.ArrayList;
import java.util.List;

public interface IPaymentRepository {
    public List<Payment> readPaymentsFor(User user);

    ArrayList<Payment> readAll();

    ArrayList<Payment> readPaymentsForMonth(int monthID);
}
