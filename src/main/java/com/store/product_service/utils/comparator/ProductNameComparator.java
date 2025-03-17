package com.store.product_service.utils.comparator;

import com.store.product_service.domain.model.Product;

public class ProductNameComparator implements IProductComparator {
    private final boolean ascending;

    public ProductNameComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Product p1, Product p2) {
        return ascending ? p1.getName().compareToIgnoreCase(p2.getName())
                : p2.getName().compareToIgnoreCase(p1.getName());
    }
}