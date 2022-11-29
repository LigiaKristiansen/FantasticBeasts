package com.exercise.onlinestore.main;
import com.exercise.onlinestore.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    //Map for shopping cart
    private Map<String, CartEntry> entries;

    public ShoppingCart(){
        this.entries = new HashMap<>();
    }
//Method for adding products to the cart
    public void addProduct(String productName){
        CartEntry productEntry = entries.get(productName.toUpperCase());
                if(productEntry!=null){
                    productEntry.increaseAmount();
                    }
                    else
                    {
                    Product product = Product.getName();
                    CartEntry entry = new CartEntry(product, 1);
                    entries.put(productName.toUpperCase(), entry);
                }
    }
//Method for removing products from the cart
    public void removeProduct(String productName){
        CartEntry productEntry = entries.get(productName.toUpperCase());
        if(productEntry!=null){
            productEntry.decreaseAmount();
        }
    }
//Method for calculating amount of products in the cart
    public int getAmount(String productName){
        CartEntry entry = entries.get(productName.toUpperCase());
        if(entry!=null){
            return entry.getAmount();
        }
        return 0;
    }
    //Method for calculating the total cost of the cart

    public double calculateTotal(){
        double total = 0;
        for(CartEntry entry:entries.values()){
            double entryCost = entry.getProduct().getPrice()*entry.getAmount();
            total = total + entryCost;
        }
        return total;
    }


}
