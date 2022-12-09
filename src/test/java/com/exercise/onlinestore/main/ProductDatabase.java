package com.exercise.onlinestore.main;

import com.exercise.onlinestore.model.Product;

import java.util.ArrayList;

public class ProductDatabase {
    ArrayList<Product> productList = new ArrayList<>();
    public ProductDatabase(){ productList.add(new Product("Bowtruckle",50000,"", 1));}
    public ArrayList<Product> getAllProducts(){
        return productList;
    }
    public Product getProductbyName(String name){return null;}
}
