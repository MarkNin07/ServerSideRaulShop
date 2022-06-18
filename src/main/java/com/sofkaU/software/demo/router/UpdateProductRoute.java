package com.sofkaU.software.demo.router;

import com.sofkaU.software.demo.dto.ProductDto;
import com.sofkaU.software.demo.usecases.UpdateProductUseCase;
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
public class UpdateProductRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "updateProducts ", operationId = "Update Products", tags = "Products",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProductDto.class)))))
    public RouterFunction<ServerResponse> updateProduct(UpdateProductUseCase updateProdUseCase){
        return route(PUT("/update/product").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDto.class)
                        .flatMap(updateProdUseCase::updateProd)
                        .flatMap(productDto -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDto))
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
    }

}
