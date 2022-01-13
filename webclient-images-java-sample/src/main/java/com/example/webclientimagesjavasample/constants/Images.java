package com.example.webclientimagesjavasample.constants;

import com.example.webclientimagesjavasample.model.entities.ImageEntity;

import java.util.List;

public class Images {

    public static final List<ImageEntity> imageCatalog = List.of(
            new ImageEntity(
                    1L,
                    1L,
                    "Notebook Dell",
                    "https://m.media-amazon.com/images/I/616PBNK19aL._AC_SL1000_.jpg"
            ),
            new ImageEntity(
                    2L,
                    2L,
                    "Celular Smartphone Galaxy A12",
                    "https://www.havan.com.br/media/catalog/product/cache/73a52df140c4d19dbec2b6c485ea6a50/c/e/celular-smartphone-galaxy-a12-64gb-6-5-samsung_442002.jpg"
            ),
            new ImageEntity(
                    3L,
                    3L,
                    "Chandon Réserve Brut",
                    "https://images-submarino.b2w.io/produtos/01/03/item/5349/9/5349936SZ.jpg"
            )
    );
}
