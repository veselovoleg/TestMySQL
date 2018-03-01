package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public static void main(String[] args) throws SQLException {
        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);
        //String query = "select * from business.products where product_id = 6"; //Print only this choose
        String query = "select * from business.products";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) { //return True, if you have next element
            int id;
            String name;
            double price;
            int shopID;

            id = resultSet.getInt("product_id");
            name = resultSet.getString("productname");
            price = resultSet.getDouble("price");
            shopID = resultSet.getInt("shop_id");
            //Always close connection
            Product product = new Product(id, name, price, shopID);
            System.out.println(product);
        }

        statement.close();
        conn.close();


    }

}
