package com.example.webclientimagesjavasample.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("image")
@AllArgsConstructor
@Getter
public class ImageEntity {

    @Id
    private Long id;

    @Indexed
    private Long productId;
    private String name;
    private String url;
}
