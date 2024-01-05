package org.example.web_app.dao.impl;

import org.example.web_app.model.Employee;
import org.example.web_app.model.Tour;

import java.util.List;

public interface IEmployeeDAO {
    List<Employee> getAll();
        Employee getBy(long id);
        boolean add(Employee employee);
        boolean update(Employee employee);
        boolean delete(long id);

    }

