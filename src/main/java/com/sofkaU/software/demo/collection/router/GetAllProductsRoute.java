package com.sofkaU.software.demo.collection.router;

import com.sofkaU.software.demo.dto.ProductDto;
import com.sofkaU.software.demo.usecases.GetAllProductsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
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
    @RouterOperation(operation = @Operation(description = "allProducts ", operationId = "get all products", tags = "Products",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProductDto.class)))))
    public RouterFunction<ServerResponse> AllProducts(GetAllProductsUseCase allProducts){
        return route(GET("/get/all/products"), request -> ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromProducer(allProducts.getAllProducts(), ProductDto.class)));
    }
}
