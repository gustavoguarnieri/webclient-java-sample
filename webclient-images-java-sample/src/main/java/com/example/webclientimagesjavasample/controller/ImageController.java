package com.example.webclientimagesjavasample.controller;

import com.example.webclientimagesjavasample.model.response.ImageResponse;
import com.example.webclientimagesjavasample.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products/{productId}/images")
@Slf4j
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    private List<ImageResponse> getImages(
            @PathVariable Long productId
    ) throws InterruptedException {
        log.info("getImages: getting list of images");
        var images = imageService.getImages(productId);
        log.info("getImages: finished getting list of images");
        return images;
    }
}
