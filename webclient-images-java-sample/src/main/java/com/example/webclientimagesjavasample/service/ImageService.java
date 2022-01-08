package com.example.webclientimagesjavasample.service;

import com.example.webclientimagesjavasample.model.response.ImageResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ImageService {

    private static final int TIME_TO_SLEEP_IN_MILLISECONDS = 5_000;

    public List<ImageResponse> getImages(Long productId) throws InterruptedException {

        Thread.sleep(TIME_TO_SLEEP_IN_MILLISECONDS);

        return Stream.of(
                        new ImageResponse(
                                1L,
                                1L,
                                "Notebook Dell",
                                "https://m.media-amazon.com/images/I/616PBNK19aL._AC_SL1000_.jpg"
                        ),
                        new ImageResponse(
                                2L,
                                2L,
                                "Celular Smartphone Galaxy A12",
                                "https://www.havan.com.br/media/catalog/product/cache/73a52df140c4d19dbec2b6c485ea6a50/c/e/celular-smartphone-galaxy-a12-64gb-6-5-samsung_442002.jpg"
                        ),
                        new ImageResponse(
                                3L,
                                3L,
                                "Chandon Réserve Brut",
                                "https://images-submarino.b2w.io/produtos/01/03/item/5349/9/5349936SZ.jpg"
                        )
                )
                .filter(image -> Objects.equals(image.getProductId(), productId))
                .collect(Collectors.toList());
    }
}
