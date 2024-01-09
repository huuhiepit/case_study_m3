package org.example.web_app.dao;

import org.example.web_app.model.Account;
import org.example.web_app.model.Customer;
import org.example.web_app.model.en.ERole;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO extends ConnectionDB{
    protected String CHECK_LOGIN_SQL = "call db_manager_tour.checkLoginAccount(?, ?);\n";
    protected String CALL_PROCEDURE_REGISTER = "CALL InsertCustomerAndAccountData(?, ?, ?, ?, ?, ?)";
    protected String SELECT_CUSTOMER_BY_ACCOUNT = "SELECT * FROM db_manager_tour.customers where accounts_id = ?;";
    public Customer getCustomerBy(long idAccount) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(SELECT_CUSTOMER_BY_ACCOUNT);
            statement.setLong(1, idAccount);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
//            long id, String name, String phone, String address, String email, String userName
            return new Customer(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("phone"),
                    resultSet.getString("address"),
                    resultSet.getString("email")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Account checkLogin(String userName, String password) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(CHECK_LOGIN_SQL);
            statement.setString(1, userName);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            rs.next();
            return new Account(rs.getLong("id"), rs.getString("userName"), rs.getString("urlImage"), ERole.valueOf(rs.getString("role")));
        } catch (SQLException e) {
            return null;
        }

    }
    public void register(String customerName, String customerPhone, String customerAddress, String customerEmail,
                                String accountUsername, String accountPassword) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(CALL_PROCEDURE_REGISTER);

            statement.setString(1, customerName);
            statement.setString(2, customerPhone);
            statement.setString(3, customerAddress);
            statement.setString(4, customerEmail);
            statement.setString(5, accountUsername);
            statement.setString(6, accountPassword);

            statement.executeUpdate();
            statement.close();
            System.out.println("Đăng ký thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
