package com.example.webclientconsumerjavasample.service;

import com.example.webclientconsumerjavasample.client.WebClientProductsJavaSampleClient;
import com.example.webclientconsumerjavasample.model.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final WebClientProductsJavaSampleClient webClientProductsJavaSampleClient;

    @Autowired
    public ProductService(WebClientProductsJavaSampleClient webClientProductsJavaSampleClient) {
        this.webClientProductsJavaSampleClient = webClientProductsJavaSampleClient;
    }

    public Flux<ProductResponse> getProducts() {
        return webClientProductsJavaSampleClient.getProducts();
    }

    public Mono<ProductResponse> getProduct(Long productId) {
        return webClientProductsJavaSampleClient.getProduct(productId);
    }
}
