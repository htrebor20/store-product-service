package com.store.product_service.domain.model;

public enum ProductCategory  {
    TECHNOLOGY("Technology"),
    HOME("Home"),
    TOOLS("Tools"),
    SPORTS("Sports");
    private final String value;

    ProductCategory (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
