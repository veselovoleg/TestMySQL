package com.jdbc;

public class Product {
    private int id;
    private int shopID;
    private String name;
    private double price;

    public Product() {}
    public Product(int id, String name, double price, int shopID){
        this.id = id;
        this.name = name;
        this.price = price;
        this.shopID = shopID;
    }

    //Override toString method for convenient printing of information
    @Override
    public String toString(){
        return "Product: [" + id + "\t" + name + "\t" + price + " Руб.\t" + shopID + "]";
    }


}
