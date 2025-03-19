package com.store.product_service.infrastruture.controllers;

import com.store.product_service.application.dtos.requests.ProductRequest;
import com.store.product_service.application.dtos.responses.ProductResponseDto;
import com.store.product_service.application.mappers.IProductRequestMappers;
import com.store.product_service.domain.model.Product;
import com.store.product_service.domain.model.ProductCategory;
import com.store.product_service.domain.ports.in.IProductManagementServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/ProductManagement")
@RequiredArgsConstructor
public class ProductManagementController {
    private final IProductRequestMappers productRequestMappers;
    private final IProductManagementServicePort productManagementServicePort;

    @PostMapping("/create")
    ResponseEntity<ProductResponseDto> createProducts(@RequestBody ProductRequest productRequest) {
        Product model = productRequestMappers.toModel(productRequest);
        Product product = productManagementServicePort.createProduct(model);
        return new ResponseEntity<>(productRequestMappers.toResponse(product), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Page<ProductResponseDto>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(required = false) ProductCategory productCategory,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
        Page<Product> productPage = productManagementServicePort.findFilteredProducts(pageable, productCategory, keyword, sortBy, direction, minPrice, maxPrice);
        Page<ProductResponseDto> responsePage = productPage.map(productRequestMappers::toResponse);
        return ResponseEntity.ok(responsePage);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id,
                                                            @RequestBody ProductRequest productRequest
    ) {
        Product model = productRequestMappers.toModel(productRequest);
        ProductResponseDto response = productRequestMappers.toResponse(productManagementServicePort.updateProduct(model, id));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

