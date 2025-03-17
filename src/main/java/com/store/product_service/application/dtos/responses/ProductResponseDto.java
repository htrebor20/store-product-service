package com.store.product_service.application.dtos.responses;

import com.store.product_service.domain.model.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
@AllArgsConstructor
public class ProductResponseDto {

    private String name;

    private BigDecimal price;

    private int stock;

    private ProductCategory productCategory;

    private String description;
}
