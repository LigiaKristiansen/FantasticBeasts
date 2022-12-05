package com.exercise.onlinestore.main;

public class Stock {
    private String item;
    private Integer inStock;

    public Stock(String item, Integer inStock) {
        this.item = item;
        this.inStock = inStock;

    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }
}
