package com.store.product_service.infrastruture.configuration;

import com.store.product_service.application.usecase.ProductManagementUseCase;
import com.store.product_service.domain.ports.in.IProductManagementServicePort;
import com.store.product_service.domain.ports.out.IProductManagementPersistencePort;
import com.store.product_service.infrastruture.adapters.ProductManagementPersistenceAdapter;
import com.store.product_service.infrastruture.mappers.IProductEntityMapper;
import com.store.product_service.infrastruture.repositories.IProductManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IProductEntityMapper productEntityMapper;
    private final IProductManagementRepository productManagementRepository;


    @Bean
    public IProductManagementPersistencePort productManagementPersistencePort() {
        return new ProductManagementPersistenceAdapter(productManagementRepository, productEntityMapper);

    }

    @Bean
    public IProductManagementServicePort productManagementServicePort() {
        return new ProductManagementUseCase(productManagementPersistencePort());
    }
}
