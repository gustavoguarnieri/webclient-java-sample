package com.example.webclientconsumerjavasample.util.mock;

import com.example.webclientconsumerjavasample.model.response.ImageResponse;
import com.example.webclientconsumerjavasample.model.response.ProductResponse;

import java.math.BigDecimal;
import java.util.List;

public class Image {

    public static final List<ImageResponse> images = List.of(
            new ImageResponse(
                    1L,
                    new ProductResponse(
                            1L,
                            "Name one",
                            "Description one",
                            new BigDecimal("100")
                    ),
                    "Image one",
                    "http://image-one.com.br"
            ),
            new ImageResponse(
                    1L,
                    new ProductResponse(
                            2L,
                            "Name two",
                            "Description two",
                            new BigDecimal("100")
                    ),
                    "Image two",
                    "http://image-two.com.br"
            )
    );
}
