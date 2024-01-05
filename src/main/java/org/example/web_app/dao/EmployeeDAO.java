package org.example.web_app.dao;

import org.example.web_app.dao.impl.IEmployeeDAO;
import org.example.web_app.model.Employee;
import org.example.web_app.model.Tour;
import org.example.web_app.model.en.ERole;
import org.example.web_app.model.en.EType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends ConnectionDB implements IEmployeeDAO {
    protected String SELECT_ALL_EMPLOYEE = "SELECT * FROM db_manager_tour.view_employee;";
    protected String SELECT_EMPLOYEE_ID = "SELECT * FROM db_manager_tour.view_employee where id = ?";
    protected String INSERT_INTO_EMPLOYEE = "call db_manager_tour.insertIntoEmployee(?, ?, ?);";
    protected String DELETE_EMPLOYEE = "call db_manager_tour.deleteEmployee(?);";
    protected String UPDATE_EMPLOYEE = "call db_manager_tour.updateEmployee(?, ?, ?, ?);";


    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                //long id, String name, String phone, String address, String userName, String urlImage, ERole role
                if(rs.getString("userName") != null) {
                    employees.add(new Employee(rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("phone"),
                            rs.getString("address"),
                            rs.getString("userName"),
                            rs.getString("urlImage"),
                            ERole.valueOf(rs.getString("role"))));
                } else {
                    employees.add(new Employee(rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("phone"),
                            rs.getString("address"),
                            null,
                            null,
                            ERole.EMPLOYEE));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public Employee getBy(long id) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_EMPLOYEE_ID);
            statement.setLong(1, id);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return new Employee(id, rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("userName"),
                        rs.getString("urlImage"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean add(Employee employee) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(INSERT_INTO_EMPLOYEE);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getPhone());
            statement.setString(3, employee.getAddress());


            System.out.println(statement);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(UPDATE_EMPLOYEE);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getPhone());
            statement.setString(3, employee.getAddress());
            statement.setLong(4, employee.getId());
            System.out.println(statement);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(DELETE_EMPLOYEE);
            statement.setLong(1, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employees = employeeDAO.getAll();

        for (Employee e: employees) {
            System.out.println(e.toString());
        }
    }
}
