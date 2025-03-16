package com.store.product_service.infrastruture.controllers;

import com.store.product_service.application.dtos.requests.ProductRequest;
import com.store.product_service.application.mappers.IProductRequestMappers;
import com.store.product_service.domain.model.Product;
import com.store.product_service.domain.ports.in.IProductManagementServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ProductManagement")
@RequiredArgsConstructor
public class ProductManagementController {
    private final IProductRequestMappers productRequestMappers;
    private final IProductManagementServicePort productManagementServicePort;

    @PostMapping("/create")
    ResponseEntity<ProductRequest> createProducts(@RequestBody ProductRequest productRequest) {
        Product model = productRequestMappers.toModel(productRequest);
        Product product = productManagementServicePort.createProduct(model);
        return new ResponseEntity<>(productRequestMappers.toRequest(product), HttpStatus.CREATED);
    }
}

