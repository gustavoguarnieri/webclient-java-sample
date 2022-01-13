package com.example.webclientimagesjavasample.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageResponse {

    private Long id;
    private Long productId;
    private String name;
    private String url;
}
