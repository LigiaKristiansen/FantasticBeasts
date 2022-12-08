package com.exercise.onlinestore.main;

import com.exercise.onlinestore.model.Product;
import java.util.ArrayList;

public class ProductSystem {
    ProductDatabase productDatabase = new ProductDatabase();
    public Product currentlyAddedProduct;

    public ProductSystem(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public boolean addProduct(String name, double price) {
        ArrayList<Product> productList = productDatabase.getAllProducts();
        for (Product product : productList) {
            if (product.getName().equals(name) && product.getPrice() == price) {
                currentlyAddedProduct = product;
                return true;
            }
        }
        return false;
    }
}