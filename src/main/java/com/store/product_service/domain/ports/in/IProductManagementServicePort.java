package com.store.product_service.domain.ports.in;

import com.store.product_service.domain.model.Product;

public interface IProductManagementServicePort {
    Product createProduct (Product product);
}
