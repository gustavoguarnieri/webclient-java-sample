package com.example.webclientconsumerjavasample.config;

import com.example.webclientconsumerjavasample.model.response.BaseExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(WebClientResponseException.NotFound.class)
    private ResponseEntity<Object> handleWebClientResponseNotFoundException(WebClientResponseException ex, WebRequest request) {
        var baseExceptionResponse = new BaseExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getLocalizedMessage(),
                ((ServletWebRequest) request).getRequest().getRequestURI()
        );
        return new ResponseEntity(baseExceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WebClientResponseException.class)
    private ResponseEntity<String> handleWebClientResponseException(WebClientResponseException ex, WebRequest request) {
        return ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());
    }
}
