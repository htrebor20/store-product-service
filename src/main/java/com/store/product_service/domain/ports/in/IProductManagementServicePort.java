package com.store.product_service.domain.ports.in;

import com.store.product_service.domain.model.Product;
import com.store.product_service.domain.model.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface IProductManagementServicePort {
    Product createProduct (Product product);

    Page<Product> findFilteredProducts (Pageable pageable, ProductCategory productCategory,
                                        String keyword, String sortBy, String direction,
                                        BigDecimal minPrice, BigDecimal maxPrice);

    Product updateProduct (Product product, Long id);
}
