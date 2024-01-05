package org.example.web_app.dao;

import org.example.web_app.model.Account;
import org.example.web_app.model.Employee;
import org.example.web_app.model.en.ERole;
import org.example.web_app.util.PasswordEncryptionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO extends ConnectionDB{
    AccountDAO accountDao = new AccountDAO();
    public List<Account> getAllAccount(){
        List<Account> accountList = new ArrayList<>();
        String SELECT_ALL_ACCOUNT = "SELECT * FROM `accounts`";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                accountList.add(new Account(resultSet.getLong("id"), resultSet.getString("userName"), resultSet.getString("password"),
                        resultSet.getString("urlImage"), ERole.valueOf(resultSet.getString("role"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accountList;
    }



    public void register(String name, String phone, String address, String email ,String username,String password) {
        accountDao.register(name, phone, address,email,username, password);
    }

//    public Account getAccountByName(String name) {
//        List<Account> accountList = getAllAccount();
//        return List.stream().filter(account -> account.getUserName().equalsIgnoreCase(userName)).findFirst().orElse(null);
//    }
}
