package com.example.webclientprodutsjavasample.service;

import com.example.webclientprodutsjavasample.constants.Products;
import com.example.webclientprodutsjavasample.exceptions.NotFoundException;
import com.example.webclientprodutsjavasample.model.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.example.webclientprodutsjavasample.constants.ErrorMessages.PRODUCT_NOT_FOUND;

@Service
public class ProductService {

    private static final int TIME_TO_SLEEP_IN_MILLISECONDS = 5_000;

    public List<ProductResponse> getProducts() throws InterruptedException {
        Thread.sleep(TIME_TO_SLEEP_IN_MILLISECONDS);

        return Products.productCatalog;
    }

    public ProductResponse getProduct(Long productId) throws InterruptedException {

        Thread.sleep(TIME_TO_SLEEP_IN_MILLISECONDS);

        return Products.productCatalog
                .stream()
                .filter(product -> Objects.equals(product.getId(), productId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(PRODUCT_NOT_FOUND));
    }
}
