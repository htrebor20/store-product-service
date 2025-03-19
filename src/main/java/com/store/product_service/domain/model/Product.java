package com.store.product_service.domain.model;

import java.math.BigDecimal;

public class Product {
    private Long id;

    private String name;

    private BigDecimal price;

    private int stock;

    private ProductCategory  productCategory;

    private String description;

    public Product() {
    }

    public Product(Long id, String name, BigDecimal price, int stock, ProductCategory productCategory, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.productCategory = productCategory;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
