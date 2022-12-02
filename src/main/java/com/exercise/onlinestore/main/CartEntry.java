package com.exercise.onlinestore.main;

import com.exercise.onlinestore.model.Product;

public class CartEntry {
    private Product product;
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
