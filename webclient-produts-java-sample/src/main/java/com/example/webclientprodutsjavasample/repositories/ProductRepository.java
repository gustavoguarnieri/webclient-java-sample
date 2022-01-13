package com.example.webclientprodutsjavasample.repositories;

import com.example.webclientprodutsjavasample.model.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
    Optional<ProductEntity> findById(Long id);
}
