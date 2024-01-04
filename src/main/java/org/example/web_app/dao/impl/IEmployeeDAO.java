package org.example.web_app.dao.impl;

import org.example.web_app.model.Employee;

import java.util.List;

public interface IEmployeeDAO {
    List<Employee> getAll();
}
