package com.example.webclientimagesjavasample.repositories;

import com.example.webclientimagesjavasample.model.entities.ImageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends MongoRepository<ImageEntity, String> {
    List<ImageEntity> findByProductId(Long id);
}
