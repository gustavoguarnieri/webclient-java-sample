package com.example.webclientimagesjavasample;

import com.example.webclientimagesjavasample.constants.Images;
import com.example.webclientimagesjavasample.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageApplication implements CommandLineRunner {

    private final ImageRepository repository;

    @Autowired
    public ImageApplication(ImageRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ImageApplication.class, args);
    }

    @Override
    public void run(String... args) {
        repository.deleteAll();
        Images.imageCatalog.forEach(repository::save);
    }

}
