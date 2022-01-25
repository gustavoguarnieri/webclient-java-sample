package com.example.webclientconsumerjavasample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enabled}") private boolean enableSwagger;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enableSwagger)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.webclientconsumerjavasample.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("WebClient Consumer Rest Api Documentation")
                .description("All necessary information is in this documentation")
                .version("1.0.0")
                .license("MIT License")
                .licenseUrl("https://choosealicense.com/licenses/mit/")
                .contact(
                        new Contact(
                                "Gustavo",
                                "https://www.linkedin.com/in/gustavo-guarnieri/",
                                "gustavo.guarnieri@gmail.com"))
                .build();
    }
}
