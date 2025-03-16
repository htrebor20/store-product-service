package com.store.product_service.infrastruture.repositories;

import com.store.product_service.infrastruture.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductManagementRepository extends JpaRepository<ProductEntity, Long> {
}
