package org.example.web_app.dao;

import org.example.web_app.model.Account;
import org.example.web_app.model.en.ERole;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends ConnectionDB{
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


}
