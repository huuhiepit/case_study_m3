package org.example.web_app.dao;

import org.example.web_app.model.en.EStatus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionDB {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/db_manager_tour";
    private final String JDBC_USERNAME = "root";
    private final String JDBC_PASSWORD = "huuhiep123";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            System.out.println("Connection Success!!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
