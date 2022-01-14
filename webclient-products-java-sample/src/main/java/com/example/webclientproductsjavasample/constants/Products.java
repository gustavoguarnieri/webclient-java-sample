package com.example.webclientproductsjavasample.constants;

import com.example.webclientproductsjavasample.model.entities.ProductEntity;

import java.math.BigDecimal;
import java.util.List;

public class Products {

    public static final List<ProductEntity> productCatalog = List.of(
            new ProductEntity(
                    1L,
                    "Notebook Dell",
                    "Notebook Ultrafino Dell Inspiron i5402-M10S 14 Full HD 11ª Geração Intel Core i5",
                    new BigDecimal(5000)
            ),
            new ProductEntity(
                    2L,
                    "Smartphone Samsung Galaxy A12",
                    "Smartphone Samsung Galaxy A12 64GB 4G Wi-Fi Tela 6.5'' Dual Chip 4GB RAM Câmera Quádrupla + Selfie 8MP",
                    new BigDecimal(1100)
            ),
            new ProductEntity(
                    3L,
                    "Chandon Réserve Brut",
                    "Chandon Réserve Brut 750 ml",
                    new BigDecimal(70)
            )
    );
}
