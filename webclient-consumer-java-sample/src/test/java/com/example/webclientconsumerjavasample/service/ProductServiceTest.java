package com.example.webclientconsumerjavasample.service;

import com.example.webclientconsumerjavasample.client.WebClientProductsJavaSampleClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static com.example.webclientconsumerjavasample.util.mock.Product.product;
import static com.example.webclientconsumerjavasample.util.mock.Product.products;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private WebClientProductsJavaSampleClient webClientProductsJavaSampleClient;

    @Test
    public void getProductsExistingProductsShouldReturnListOfProducts() {
        when(webClientProductsJavaSampleClient.getProducts())
                .thenReturn(Flux.fromIterable(products));

        var result = productService.getProducts();

        assertEquals(2, (long) Optional.ofNullable(result.count().block()).orElse(0L));

        verify(webClientProductsJavaSampleClient, times(1)).getProducts();
    }

    @Test
    public void getProductExistingProductShouldReturnProduct() {
        when(webClientProductsJavaSampleClient.getProduct(any()))
                .thenReturn(Mono.just(product));

        var result = productService.getProduct(any()).block();

        assertEquals(result, product);

        verify(webClientProductsJavaSampleClient, times(1)).getProduct(any());
    }
}
