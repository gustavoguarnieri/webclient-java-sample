package com.example.webclientimagesjavasample.service;

import com.example.webclientimagesjavasample.model.entities.ImageEntity;
import com.example.webclientimagesjavasample.model.response.ImageResponse;
import com.example.webclientimagesjavasample.repositories.ImageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageService {

    private static final int TIME_TO_SLEEP_IN_MILLISECONDS = 5_000;
    private final ImageRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public ImageService(ImageRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<ImageResponse> getImages(Long productId) throws InterruptedException {

        Thread.sleep(TIME_TO_SLEEP_IN_MILLISECONDS);

        return repository.findByProductId(productId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ImageResponse convertToDto(ImageEntity productEntity) {
        return modelMapper.map(productEntity, ImageResponse.class);
    }
}
