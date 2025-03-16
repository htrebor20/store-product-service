package com.store.product_service.infrastruture.adapters;

import com.store.product_service.domain.model.Product;
import com.store.product_service.domain.ports.out.IProductManagementPersistencePort;
import com.store.product_service.infrastruture.entities.ProductEntity;
import com.store.product_service.infrastruture.mappers.IProductEntityMapper;
import com.store.product_service.infrastruture.repositories.IProductManagementRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductManagementPersistenceAdapter implements IProductManagementPersistencePort {
    private final IProductManagementRepository productManagementRepository;
    private final IProductEntityMapper productEntityMapper;
    @Override
    public Product createProduct(Product product) {
        ProductEntity entity = productEntityMapper.toEntity(product);
        return productEntityMapper.toModel(productManagementRepository.save(entity));

    }
}
