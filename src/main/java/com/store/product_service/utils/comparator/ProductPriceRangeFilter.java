package com.store.product_service.utils.comparator;

import com.store.product_service.domain.model.Product;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class ProductPriceRangeFilter implements Predicate<Product> {
    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;

    public ProductPriceRangeFilter(BigDecimal minPrice, BigDecimal maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean test(Product product) {
        return product.getPrice().compareTo(minPrice) >= 0 && product.getPrice().compareTo(maxPrice) <= 0;    }
}