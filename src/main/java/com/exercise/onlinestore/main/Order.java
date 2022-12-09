package com.exercise.onlinestore.main;

import javafx.scene.control.Label;

public class Order {
    private String custName;
    private Integer orderNr;
    private String itemOrdered;
    private Integer quantity;
    private Integer price;

    public Order() {}

    public Order(Label productNameLabel, Integer numOfItemsAdded) {

    }

    public Order(String custName, Integer orderNr, String item, Integer quantity) {
        this.custName = custName;
        this.orderNr = orderNr;
        this.itemOrdered = item;
        this.quantity = quantity;
    }

    public Order(String itemOrdered, Integer quantity, Integer price) {
        this.itemOrdered = itemOrdered;
        this.quantity = quantity;
        this.price = price;
    }

    public Order() {

    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        if (custName != null)
            this.custName = custName;
        else
            throw new IllegalArgumentException("Costumer name must contain a value.");
    }

    public Integer getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(Integer orderNr) {
        if (orderNr >= 0)
            this.orderNr = orderNr;
        else
            throw new IllegalArgumentException("Order number must be a positive value.");
    }

    public String getItemOrdered() {
        return itemOrdered;
    }

    public void setItemOrdered(String itemOrdered) {
        this.itemOrdered = itemOrdered;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
