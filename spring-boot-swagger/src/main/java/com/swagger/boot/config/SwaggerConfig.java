package com.swagger.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//whats apis to show ie only those with @Api
            .build()
            .apiInfo(apiInfo());
    }

    
    /**
     * String title,  String description, String version, String termsOfServiceUrl, String contact, String license, String licenseUrl
     */
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
            "Sample Swagger Application",
            "This is a description of your API.",
            "1.0",
            null, //terms of use URL
            "david.mcfadden@outlook.com",
            null, //license
            null //license URL
        );
        return apiInfo;
    }
}