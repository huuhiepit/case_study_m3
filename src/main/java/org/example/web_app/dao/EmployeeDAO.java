package org.example.web_app.dao;

import org.example.web_app.dao.impl.IEmployeeDAO;
import org.example.web_app.model.Employee;
import org.example.web_app.model.en.ERole;
import org.example.web_app.util.PasswordEncryptionUtil;

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
    public void register(String name, String phone, String address, String username,String password) {
        String REGISTER_CUSTOMER = "INSERT INTO `customers` (`name`, `phone`, `address`, `username`, `password`) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_CUSTOMER);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,phone);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,username);
            preparedStatement.setString(5, PasswordEncryptionUtil.encryptPassword(password));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        String SELECT_ALL_USER = "SELECT * FROM `users`";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(SELECT_ALL_USER);
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setAddress(resultSet.getString("address"));
                employee.setUserName(resultSet.getString("username"));
                employee.setUrlImage(resultSet.getString("urlimage"));
                if(resultSet.getString("address")!=null){
                    employee.setAddress(resultSet.getString("address"));
                }else employee.setAddress(null);
                if(resultSet.getString("phone")!=null){
                    employee.setPhone(resultSet.getString("phone"));
                }else employee.setPhone(null);
                employee.setRole(ERole.EMPLOYEE);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException ignored){
        }
        return employeeList;
    }

}
