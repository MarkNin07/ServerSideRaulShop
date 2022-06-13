package com.sofkaU.software.demo.collection.router;


import com.sofkaU.software.demo.dto.ProductDto;
import com.sofkaU.software.demo.usecases.DeleteProductUseCase;
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
public class DeleteProductRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "Delete product ", operationId = "delete product", tags = "Products",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProductDto.class)))))
    public RouterFunction<ServerResponse> deleteProduct(DeleteProductUseCase deleteProd){
        return route(DELETE("/delete/product/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> deleteProd.deleteProduct(request.pathVariable("id"))
                        .flatMap((del)-> ServerResponse.status(HttpStatus.ACCEPTED).build())
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.NOT_FOUND).build()));

    }

}
