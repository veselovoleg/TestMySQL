package com.jdbc;

import java.sql.*;

public class Main {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public static void main(String[] args)  {

        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException ex) {
            System.out.println("Error! Can't to register driver");
            return;
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement())     {
            //We can add new data
//            statement.execute("insert into business.products (productname, price, shop_id) values (\"Sousage\", 44,2 )");
            //Change old data
//            statement.executeUpdate("update business.products set productname = \"Snikers\" where product_id = 6");
            //Add several new values
//            statement.addBatch("insert into business.products (productname, price, shop_id) values (\"Ketchup\", 57,2 )");
//            statement.addBatch("insert into business.products (productname, price, shop_id) values (\"Nuts\", 68,1 )");
//            statement.addBatch("insert into business.products (productname, price, shop_id) values (\"Something\", 37,3 )");
//            statement.executeBatch();
//            statement.clearBatch();
            //Return result
//              statement.executeQuery("select * from business.products");

            System.out.println("Successful!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
