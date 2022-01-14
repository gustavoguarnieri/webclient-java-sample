package com.example.webclientproductsjavasample.controller;

import com.example.webclientproductsjavasample.model.response.ProductResponse;
import com.example.webclientproductsjavasample.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    private List<ProductResponse> getProducts() throws InterruptedException {
        log.info("getProducts: getting list of products");
        var products = productService.getProducts();
        log.info("getProducts: finished getting list of products");
        return products;
    }

    @GetMapping("/{productId}")
    private ProductResponse getProduct(@PathVariable Long productId) throws InterruptedException {
        log.info("getProduct: getting product number: {}", productId);
        var product = productService.getProduct(productId);
        log.info("getProduct: finished getting product number: {}", productId);
        return product;
    }
}
