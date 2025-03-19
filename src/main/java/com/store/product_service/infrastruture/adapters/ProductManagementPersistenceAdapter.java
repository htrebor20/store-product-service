package com.store.product_service.infrastruture.adapters;

import com.store.product_service.domain.model.Product;
import com.store.product_service.domain.model.ProductCategory;
import com.store.product_service.domain.ports.out.IProductManagementPersistencePort;
import com.store.product_service.infrastruture.entities.ProductEntity;
import com.store.product_service.infrastruture.mappers.IProductEntityMapper;
import com.store.product_service.infrastruture.repositories.IProductManagementRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductManagementPersistenceAdapter implements IProductManagementPersistencePort {
    private final IProductManagementRepository productManagementRepository;
    private final IProductEntityMapper productEntityMapper;
    @Override
    public Product createProduct(Product product) {
        ProductEntity entity = productEntityMapper.toEntity(product);
        return productEntityMapper.toModel(productManagementRepository.save(entity));

    }

    @Override
    public Page<Product> findFilteredProducts(Pageable pageable, ProductCategory productCategory) {

        Page<ProductEntity> productEntities = productManagementRepository.findByProductCategory(productCategory, pageable);

        return productEntities.map(productEntityMapper::toModel);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        ProductEntity productEntity = productManagementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with ID " + id + " not found"));

        productEntity.setName(Optional.ofNullable(product.getName()).orElse(productEntity.getName()));
        productEntity.setPrice(Optional.ofNullable(product.getPrice()).orElse(productEntity.getPrice()));
        productEntity.setStock(Optional.of(product.getStock()).orElse(productEntity.getStock()));
        productEntity.setProductCategory(Optional.ofNullable(product.getProductCategory()).orElse(productEntity.getProductCategory()));
        productEntity.setDescription(Optional.ofNullable(product.getDescription()).orElse(productEntity.getDescription()));

        ProductEntity updatedEntity = productManagementRepository.save(productEntity);

        return productEntityMapper.toModel(updatedEntity);
    }
}
