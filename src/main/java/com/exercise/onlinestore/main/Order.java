package com.exercise.onlinestore.main;

public class Order {
    private String custName;
    private Integer orderNr;
    private String itemOrdered;
    private Integer quantity;

    public Order(){
    }

    public Order(String custName, Integer orderNr, String item, Integer quantity) {
        this.custName = custName;
        this.orderNr = orderNr;
        this.itemOrdered = item;
        this.quantity = quantity;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(Integer orderNr) {
        this.orderNr = orderNr;
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
