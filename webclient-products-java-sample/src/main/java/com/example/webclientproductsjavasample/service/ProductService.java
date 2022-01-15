package com.example.webclientproductsjavasample.service;

import com.example.webclientproductsjavasample.constants.ErrorMessages;
import com.example.webclientproductsjavasample.exceptions.NotFoundException;
import com.example.webclientproductsjavasample.model.entities.ProductEntity;
import com.example.webclientproductsjavasample.model.response.ProductResponse;
import com.example.webclientproductsjavasample.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final int TIME_TO_SLEEP_IN_MILLISECONDS = 5_000;
    private final ProductRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<ProductResponse> getProducts() throws InterruptedException {

        Thread.sleep(TIME_TO_SLEEP_IN_MILLISECONDS);

        return repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public ProductResponse getProduct(Long productId) throws InterruptedException {

        Thread.sleep(TIME_TO_SLEEP_IN_MILLISECONDS);

        var product = repository.findById(productId)
                .orElseThrow(() -> new NotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));

        return convertToDto(product);
    }

    private ProductResponse convertToDto(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ProductResponse.class);
    }
}
