package com.example.webclientconsumerjavasample.service;

import com.example.webclientconsumerjavasample.client.WebClientImagesJavaSampleClient;
import com.example.webclientconsumerjavasample.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.webclientconsumerjavasample.constants.ErrorMessages.IMAGES_NOT_FOUND;
import static com.example.webclientconsumerjavasample.util.mock.Image.images;
import static com.example.webclientconsumerjavasample.util.mock.Product.product;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ImageServiceTest {

    @InjectMocks
    private ImageService imageService;

    @Mock
    private WebClientImagesJavaSampleClient webClientImagesJavaSampleClient;

    @Mock
    private ProductService productService;

    @Test
    public void getSyncImagesExistingImagesShouldReturnListOfImages() {
        when(productService.getProduct(any()))
                .thenReturn(Mono.just(product));

        when(webClientImagesJavaSampleClient.getImages(any()))
                .thenReturn(Flux.fromIterable(images));

        var result = imageService.getSyncImages(any());

        assertEquals(2, result.size());

        verify(productService, times(1)).getProduct(any());
        verify(webClientImagesJavaSampleClient, times(1)).getImages(any());
    }

    @Test
    public void getSyncImagesNotExistingProductShouldThrowNotFoundException() {
        when(productService.getProduct(any()))
                .thenThrow(new NotFoundException(""));

        assertThrows(
                NotFoundException.class,
                () -> imageService.getSyncImages(any())
        );

        verify(productService, times(1)).getProduct(any());
        verify(webClientImagesJavaSampleClient, times(0)).getImages(any());
    }

    @Test
    public void getSyncImagesNotExistingImagesShouldThrowNotFoundException() {
        when(productService.getProduct(any()))
                .thenReturn(Mono.just(product));

        when(webClientImagesJavaSampleClient.getImages(any()))
                .thenThrow(new NotFoundException(IMAGES_NOT_FOUND));

        var result = assertThrows(
                NotFoundException.class,
                () -> imageService.getSyncImages(any())
        );

        assertEquals(IMAGES_NOT_FOUND, result.getMessage());
        verify(productService, times(1)).getProduct(any());
        verify(webClientImagesJavaSampleClient, times(1)).getImages(any());
    }

    @Test
    public void getAsyncImagesExistingImagesShouldReturnListOfImages() {
        when(productService.getProduct(any()))
                .thenReturn(Mono.just(product));

        when(webClientImagesJavaSampleClient.getImages(any()))
                .thenReturn(Flux.fromIterable(images));

        var result = imageService.getAsyncImages(any());

        assertEquals(2, result.size());

        verify(productService, times(1)).getProduct(any());
        verify(webClientImagesJavaSampleClient, times(1)).getImages(any());
    }

    @Test
    public void getAsyncImagesNotExistingProductShouldThrowNotFoundException() {
        when(productService.getProduct(any()))
                .thenThrow(new NotFoundException(""));

        assertThrows(
                NotFoundException.class,
                () -> imageService.getAsyncImages(any())
        );

        verify(productService, times(1)).getProduct(any());
        verify(webClientImagesJavaSampleClient, times(0)).getImages(any());
    }

    @Test
    public void getAsyncImagesNotExistingImagesShouldThrowNotFoundException() {
        when(productService.getProduct(any()))
                .thenReturn(Mono.just(product));

        when(webClientImagesJavaSampleClient.getImages(any()))
                .thenThrow(new NotFoundException(IMAGES_NOT_FOUND));

        var result = assertThrows(
                NotFoundException.class,
                () -> imageService.getAsyncImages(any())
        );

        assertEquals(IMAGES_NOT_FOUND, result.getMessage());
        verify(productService, times(1)).getProduct(any());
        verify(webClientImagesJavaSampleClient, times(1)).getImages(any());
    }
}
