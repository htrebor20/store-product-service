package com.store.product_service.domain.ports.out;

import com.store.product_service.domain.model.Product;
import com.store.product_service.domain.model.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductManagementPersistencePort {
    Product createProduct (Product product);
    Page<Product> findFilteredProducts (Pageable page, ProductCategory productCategory);
    Product updateProduct (Product product, Long id);
}
