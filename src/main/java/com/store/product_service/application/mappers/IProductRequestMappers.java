package com.store.product_service.application.mappers;

import com.store.product_service.application.dtos.requests.ProductRequest;
import com.store.product_service.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IProductRequestMappers {
    Product toModel (ProductRequest productRequest);
    ProductRequest toRequest (Product product);
}
