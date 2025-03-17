package com.store.product_service.utils.comparator;

import com.store.product_service.domain.model.Product;

public class ProductPriceComparator implements IProductComparator {
    private final boolean ascending;

    public ProductPriceComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Product p1, Product p2) {
        return ascending ? (p1.getPrice().compareTo(p2.getPrice()))
                : (p2.getPrice().compareTo(p1.getPrice()));
    }
}
