package com.sofkaU.software.demo.router;


import com.sofkaU.software.demo.dto.ProductDto;
import com.sofkaU.software.demo.usecases.CreateProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateProductRoute {

    @Bean
    public RouterFunction<ServerResponse> createAProduct(CreateProductUseCase createProd){
        return route(POST("/create/product").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDto.class)
                        .flatMap(createProd::createProduct)
                        .flatMap(productDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(createProd))
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));

    }
}
