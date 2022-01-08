package com.example.webclientconsumerjavasample.client;

import com.example.webclientconsumerjavasample.model.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class WebClientProductsJavaSampleClient {

    private final WebClient webClient;
    private static final String BASE_PATH = "http://localhost:9082/api/v1/products";

    @Autowired
    public WebClientProductsJavaSampleClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<ProductResponse> getProducts() {
        return webClient
                .get()
                .uri(BASE_PATH)
                .retrieve()
                .bodyToFlux(ProductResponse.class);
    }

    public Mono<ProductResponse> getProduct(Long productId) {
        return webClient
                .get()
                .uri(BASE_PATH + "/{productId}", productId)
                .retrieve()
                .bodyToMono(ProductResponse.class);
    }
}
