package com.store.product_service.application.usecase;

import com.store.product_service.domain.model.Product;
import com.store.product_service.domain.model.ProductCategory;
import com.store.product_service.domain.ports.in.IProductManagementServicePort;
import com.store.product_service.domain.ports.out.IProductManagementPersistencePort;
import com.store.product_service.utils.comparator.ProductNameComparator;
import com.store.product_service.utils.comparator.ProductNameFilter;
import com.store.product_service.utils.comparator.ProductPriceComparator;
import com.store.product_service.utils.comparator.ProductPriceRangeFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProductManagementUseCase implements IProductManagementServicePort {
    private final IProductManagementPersistencePort productManagementPersistencePort;

    @Override
    public Product createProduct(Product product) {
        return productManagementPersistencePort.createProduct(product);
    }

    @Override
    public Page<Product> findFilteredProducts(
            Pageable pageable, ProductCategory productCategory,
            String keyword, String sortBy, String direction,
            BigDecimal minPrice, BigDecimal maxPrice) {

        Page<Product> productPage = productManagementPersistencePort.findFilteredProducts(pageable, productCategory);
        List<Product> products = productPage.getContent();


        if (keyword != null && !keyword.isEmpty()) {
            products = products.stream().filter(new ProductNameFilter(keyword)).collect(Collectors.toList());
        }

        if (minPrice != null && maxPrice != null) {
            products = products.stream().filter(new ProductPriceRangeFilter(minPrice, maxPrice)).collect(Collectors.toList());
        }

        boolean ascending = "asc".equalsIgnoreCase(direction);
        Comparator<Product> comparator = switch (sortBy) {
            case "name" -> new ProductNameComparator(ascending);
            case "price" -> new ProductPriceComparator(ascending);
            default -> Comparator.comparing(Product::getId);
        };

        List<Product> sortedProducts = products.stream().sorted(comparator).collect(Collectors.toList());

        return new PageImpl<>(sortedProducts, pageable, sortedProducts.size());
    }
}