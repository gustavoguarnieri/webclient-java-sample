package com.example.webclientprodutsjavasample.constants;

import com.example.webclientprodutsjavasample.model.response.ProductResponse;

import java.math.BigDecimal;
import java.util.List;

public class Products {

    public static final List<ProductResponse> productCatalog = List.of(
            new ProductResponse(
                    1L,
                    "Notebook Dell",
                    "Notebook Ultrafino Dell Inspiron i5402-M10S 14 Full HD 11ª Geração Intel Core i5",
                    new BigDecimal(5000)
            ),
            new ProductResponse(
                    2L,
                    "Smartphone Samsung Galaxy A12",
                    "Smartphone Samsung Galaxy A12 64GB 4G Wi-Fi Tela 6.5'' Dual Chip 4GB RAM Câmera Quádrupla + Selfie 8MP",
                    new BigDecimal(1100)
            ),
            new ProductResponse(
                    3L,
                    "Chandon Réserve Brut",
                    "Chandon Réserve Brut 750 ml",
                    new BigDecimal(70)
            )
    );
}
