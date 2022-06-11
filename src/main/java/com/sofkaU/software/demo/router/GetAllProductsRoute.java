package com.sofkaU.software.demo.router;

import com.sofkaU.software.demo.dto.ProductDto;
import com.sofkaU.software.demo.usecases.GetAllProductsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllProductsRoute {

    @Bean
    public RouterFunction<ServerResponse> AllProducts(GetAllProductsUseCase allProducts){
        return route(GET("/get/all/products"), request -> ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromProducer(allProducts.getAllProducts(), ProductDto.class)));
    }
}
