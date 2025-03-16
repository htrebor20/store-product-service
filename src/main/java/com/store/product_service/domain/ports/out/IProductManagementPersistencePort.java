package com.store.product_service.domain.ports.out;

import com.store.product_service.domain.model.Product;

public interface IProductManagementPersistencePort {
    Product createProduct (Product product);
}
