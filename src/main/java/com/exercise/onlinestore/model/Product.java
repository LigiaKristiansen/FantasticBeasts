package com.exercise.onlinestore.model;

public class Product {

    private String name;
    private String imgSrc;
    private double price;
    private String color;
    private String description;
    private Integer inStock;

    public Product(String name, double price, String description, Integer inStock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.inStock = inStock;
    }

    public Product() {
    }

    public static Product valueOf(String productName) {
        return null;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

