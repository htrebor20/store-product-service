package com.store.product_service.infrastruture.repositories;

import com.store.product_service.domain.model.ProductCategory;
import com.store.product_service.infrastruture.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductManagementRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p FROM ProductEntity p WHERE (:category IS NULL OR p.productCategory = :category)")
    Page<ProductEntity> findByProductCategory(@Param("category") ProductCategory category, Pageable pageable);

}
