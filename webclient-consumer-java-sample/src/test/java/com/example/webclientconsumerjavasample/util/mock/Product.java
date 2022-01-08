package com.example.webclientconsumerjavasample.util.mock;

import com.example.webclientconsumerjavasample.model.response.ProductResponse;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    public static final List<ProductResponse> products = List.of(
            new ProductResponse(
                    1L,
                    "Name one",
                    "Description one",
                    new BigDecimal("100")
            ),
            new ProductResponse(
                    2L,
                    "Name two",
                    "Description two",
                    new BigDecimal("100")
            )
    );

    public static final ProductResponse product = new ProductResponse(
                    1L,
                    "Name one",
                    "Description one",
                    new BigDecimal("100")
            );
}
