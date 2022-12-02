package com.exercise.onlinestore.main;

import com.exercise.onlinestore.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private static ShoppingCart INSTANCE;
    //private final Map<String, CartEntry> entries;

/*    private ShoppingCart() {
        this.entries = new HashMap<>();
    }*/

    public static ShoppingCart getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ShoppingCart();
        }
        return INSTANCE;
    }

    public void addProducts(String productName) {
    }

    /*TODO Skall koden vara kvar?
    public void addProducts(String productName) {
        CartEntry productEntry = entries.get(productName.toUpperCase());
        if (productEntry != null) {
            productEntry.increaseQuantity();
        } else {
            Product product = Product.valueOf(productName);
            CartEntry entry = new CartEntry(product, 1);
            entries.put(productName.toUpperCase(), entry);
        }
    }

     */

   /* public void removeProduct(String productName) {
        CartEntry productEntry = entries.get(productName.toUpperCase());
        if (productEntry != null) {
            productEntry.decreaseQuantity();
        }
    }

    public int getQuantity(String productName) {
        CartEntry entry = entries.get(productName.toUpperCase());
        if (entry != null) {
            return entry.getQuantity();
        }
        return 0;
    }

    public double calculateTotal() {
        double total = 0;
        for (CartEntry entry : entries.values()) {
            double entryCost = entry.getProduct().getPrice() * entry.getQuantity();
            total = total + entryCost;
        }
        return total;
    }

    public List<CartEntry> getEntries() {
        return new ArrayList<>(entries.values());
    }*/

}
