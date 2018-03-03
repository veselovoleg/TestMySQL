package com.jdbc;

import java.sql.*;

public class Main {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public static void main(String[] args) throws SQLException {

        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);

        String query = "select * from business.products"; //Print only this choose

        //The query is written to the memory allocated to the object preparedStatement.
        // Next, we can use it many times in a row at different values.
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("productname"));
        }

        conn.close();


    }

}
