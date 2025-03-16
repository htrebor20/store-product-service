package com.store.product_service.infrastruture.mappers;

import com.store.product_service.domain.model.Product;
import com.store.product_service.infrastruture.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IProductEntityMapper {
    Product toModel (ProductEntity productEntity);
    ProductEntity toEntity(Product product);
}
