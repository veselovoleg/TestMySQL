package com.jdbc;

import java.sql.*;

public class Main {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public static void main(String[] args) throws SQLException {

        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);


        //We can insert our data to the table
        String INSERT = "insert into business.products (productname, price, shop_id) values (?,?,?)";
        PreparedStatement preparedStatementInsert = conn.prepareStatement(INSERT);
        preparedStatementInsert.setString(1,"Naggets");
        preparedStatementInsert.setDouble(2, 98.35);
        preparedStatementInsert.setInt(3, 2);
        preparedStatementInsert.execute();

        //The query is written to the memory allocated to the object preparedStatement.
        // Next, we can use it many times in a row at different values.
        String query = "select * from business.products";
        PreparedStatement preparedStatementForSelect = conn.prepareStatement(query);
        ResultSet resultSet = preparedStatementForSelect.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("product_id")+ " "+resultSet.getString("productname"));
        }

        preparedStatementForSelect.close();
        conn.close();


    }

}
