package org.example.web_app.dao.impl;

import org.example.web_app.model.Customer;
import org.example.web_app.model.Employee;
import org.example.web_app.model.Tour;

import java.util.List;

public interface ICustomerDAO {
    List<Customer> getAll();
    Customer getBy(long id);
    boolean add(Customer customer);
    boolean update(Customer customer);
    boolean delete(long id);

}

