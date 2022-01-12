package com.example.webclientprodutsjavasample.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("product")
@AllArgsConstructor
@Getter
public class ProductEntity {

    @Id
    private Long id;

    @Indexed
    private String name;
    private String description;
    private BigDecimal price;
}
