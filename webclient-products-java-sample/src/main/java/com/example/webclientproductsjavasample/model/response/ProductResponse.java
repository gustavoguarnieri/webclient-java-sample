package com.example.webclientproductsjavasample.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
