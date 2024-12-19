package com.example.bai_tap.model;

import javax.persistence.*;

@Entity (name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT")
    private Integer id;
    @Column(name = "name_product", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;
    @Column(name = "price", columnDefinition = "INT", nullable = false)
    private Integer price;
    @Column(name = "description_product", columnDefinition = "VARCHAR(255)")
    private String description;
    @Column(name = "supplier", columnDefinition = "VARCHAR(50)", nullable = false)
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
