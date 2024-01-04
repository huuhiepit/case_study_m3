package org.example.web_app.dao;

import org.example.web_app.dao.impl.IEmployeeDAO;
import org.example.web_app.model.Employee;
import org.example.web_app.model.en.ERole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends ConnectionDB implements IEmployeeDAO {
    protected String SELECT_ALL_EMPLOYEE = "SELECT * FROM db_manager_tour.view_employee;";
    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                //long id, String name, String phone, String address, String userName, String urlImage, ERole role
                employees.add(new Employee(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("userName"),
                        rs.getString("urlImage"),
                        ERole.valueOf(rs.getString("role"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employees = employeeDAO.getAll();

        for (Employee e: employees) {
            System.out.println(e.toString());
        }
    }
}
