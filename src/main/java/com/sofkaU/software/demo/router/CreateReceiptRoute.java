package com.sofkaU.software.demo.router;

import com.sofkaU.software.demo.dto.ReceiptDto;
import com.sofkaU.software.demo.usecases.CreateReceiptUseCase;
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
public class CreateReceiptRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "Create receipt", operationId = "createReceipt", tags = "Receipts",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ReceiptDto.class)))))
    public RouterFunction<ServerResponse> createReceipt(CreateReceiptUseCase receiptUseCase){
        return route(POST("/create/receipt").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ReceiptDto.class)
                        .flatMap(receiptUseCase::createReceipt)
                        .flatMap(receiptDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(receiptDto))
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
    }
}
