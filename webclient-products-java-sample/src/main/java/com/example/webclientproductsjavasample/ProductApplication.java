package com.example.webclientproductsjavasample;

import com.example.webclientproductsjavasample.constants.Products;
import com.example.webclientproductsjavasample.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner {

    private final ProductRepository repository;

    @Autowired
    public ProductApplication(ProductRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Override
    public void run(String... args) {
        repository.deleteAll();
        Products.productCatalog.forEach(repository::save);
    }
}
