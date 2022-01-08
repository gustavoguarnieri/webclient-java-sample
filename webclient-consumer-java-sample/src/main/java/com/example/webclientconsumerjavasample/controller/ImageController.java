package com.example.webclientconsumerjavasample.controller;

import com.example.webclientconsumerjavasample.model.response.ImageResponse;
import com.example.webclientconsumerjavasample.service.ImageService;
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

    @GetMapping("/sync")
    private List<ImageResponse> getSyncImages(@PathVariable Long productId) {
        log.info("getSyncImages: getting sync list of images");
        var images = imageService.getSyncImages(productId);
        log.info("getSyncImages: finished sync getting list of images");
        return images;
    }

    @GetMapping("/async")
    private List<ImageResponse> getAsyncImages(@PathVariable Long productId) {
        log.info("getAsyncImages: getting async list of images");
        var images = imageService.getAsyncImages(productId);
        log.info("getAsyncImages: finished async getting list of images");
        return images;
    }
}
