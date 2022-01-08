package com.example.webclientconsumerjavasample.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageResponse {

    private Long id;
    private ProductResponse product;
    private String name;
    private String url;
}