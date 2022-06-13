package com.sofkaU.software.demo.collection.router;


import com.sofkaU.software.demo.dto.BillDto;
import com.sofkaU.software.demo.dto.ProductDto;
import com.sofkaU.software.demo.usecases.CreateProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
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
    @RouterOperation(operation = @Operation(description = "Create product ", operationId = "create product", tags = "Products",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProductDto.class)))))
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
