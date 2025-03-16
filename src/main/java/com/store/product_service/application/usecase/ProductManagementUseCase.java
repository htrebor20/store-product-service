package com.store.product_service.application.usecase;

import com.store.product_service.domain.model.Product;
import com.store.product_service.domain.ports.in.IProductManagementServicePort;
import com.store.product_service.domain.ports.out.IProductManagementPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductManagementUseCase implements IProductManagementServicePort {
    private final IProductManagementPersistencePort productManagementPersistencePort;

    @Override
    public Product createProduct(Product product) {
        return productManagementPersistencePort.createProduct(product);
    }
}
