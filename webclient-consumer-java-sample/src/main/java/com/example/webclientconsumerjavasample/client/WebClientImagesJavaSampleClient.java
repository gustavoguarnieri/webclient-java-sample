package com.example.webclientconsumerjavasample.client;

import com.example.webclientconsumerjavasample.model.response.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class WebClientImagesJavaSampleClient {

    private final WebClient webClient;
    private static final String BASE_PATH = "http://localhost:9081/api/v1/products/{productId}/images";

    @Autowired
    public WebClientImagesJavaSampleClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<ImageResponse> getImages(Long productId) {
        return webClient
                .get()
                .uri(BASE_PATH, productId)
                .retrieve()
                .bodyToFlux(ImageResponse.class);
    }
}
