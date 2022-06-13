package com.sofkaU.software.demo.collection.router;

import com.sofkaU.software.demo.dto.BillDto;
import com.sofkaU.software.demo.usecases.CreateBillUseCase;
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
public class CreateBillRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "Create bill ", operationId = "createBill", tags = "Bills",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = BillDto.class)))))
    public RouterFunction<ServerResponse> createBill(CreateBillUseCase createBillUseCase){
        return route(POST("/create/bill").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BillDto.class)
                        .flatMap(createBillUseCase::createBill)
                        .flatMap(billDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(billDto))
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
    }
}
