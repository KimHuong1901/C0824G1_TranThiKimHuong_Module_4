package com.example.bai_tap.model;

public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private String description;
    private String supplier;
    public Product() {}
    public Product(Integer id, String name, Integer price, String description, String supplier) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.supplier = supplier;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
