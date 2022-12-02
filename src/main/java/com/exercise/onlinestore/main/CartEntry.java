package com.exercise.onlinestore.main;

import com.exercise.onlinestore.model.Product;

public class CartEntry {
    private Product product;
    private int quantity;

    public CartEntry(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void increaseQuantity(){
        this.quantity++;
    }
    public void decreaseQuantity(){
        if(this.quantity>0){this.quantity--;
        }
    }
}

    private int amount;
    public CartEntry(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void increaseAmount(){
        this.amount++;
    }public void decreaseAmount(){
        if(this.amount>0){
        this.amount--;
        }
    }
}
