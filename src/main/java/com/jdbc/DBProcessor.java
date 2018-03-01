package com.jdbc;

import com.mysql.jdbc.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBProcessor {
    private Connection connection;
    Driver driver = new com.mysql.jdbc.Driver();

    public DBProcessor () throws SQLException {
        DriverManager.registerDriver(driver);
    }
    public Connection getConnection(String url, String username, String password) throws SQLException {
        if (connection != null) return connection; //Check previous connection
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

}
