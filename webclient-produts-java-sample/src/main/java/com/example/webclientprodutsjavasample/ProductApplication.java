package com.example.webclientprodutsjavasample;

import com.example.webclientprodutsjavasample.constants.Products;
import com.example.webclientprodutsjavasample.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner {

    private final ProductRepository repository;

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
