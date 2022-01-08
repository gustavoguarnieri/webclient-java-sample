package com.example.webclientconsumerjavasample.service;

import com.example.webclientconsumerjavasample.client.WebClientImagesJavaSampleClient;
import com.example.webclientconsumerjavasample.exceptions.NotFoundException;
import com.example.webclientconsumerjavasample.model.response.ImageResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

import static com.example.webclientconsumerjavasample.constants.ErrorMessages.IMAGES_NOT_FOUND;

@Service
public class ImageService {

    private final WebClientImagesJavaSampleClient webClientImagesJavaSampleClient;
    private final ProductService productService;

    public ImageService(
            WebClientImagesJavaSampleClient webClientImagesJavaSampleClient,
            ProductService productService
    ) {
        this.webClientImagesJavaSampleClient = webClientImagesJavaSampleClient;
        this.productService = productService;
    }

    public List<ImageResponse> getSyncImages(Long productId) {
        var product = productService.getProduct(productId).block();
        var images = Optional.ofNullable(
                webClientImagesJavaSampleClient.getImages(productId).collectList().block()
        ).orElseThrow(() -> new NotFoundException(IMAGES_NOT_FOUND));

        images.forEach(image -> image.setProduct(product));

        return images;
    }

    public List<ImageResponse> getAsyncImages(Long productId) {
        var product = productService.getProduct(productId);
        var images = webClientImagesJavaSampleClient.getImages(productId).collectList();

        return Mono.zip(images, product)
                .map(
                        tuple -> {
                            tuple.getT1().forEach(image -> image.setProduct(tuple.getT2()));
                            return tuple.getT1();
                        }
                ).block();
    }
}
