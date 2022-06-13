package com.sofkaU.software.demo.collection.router;

import com.sofkaU.software.demo.dto.BillDto;
import com.sofkaU.software.demo.usecases.GetAllBillsUseCase;
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
public class GetAllBillsRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "Get all bills ", operationId = "getAllBills", tags = "Bills",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = BillDto.class)))))
    public RouterFunction<ServerResponse> AllBills (GetAllBillsUseCase allBillsUseCase){
        return route(GET("/get/all/bills"), request -> ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromProducer(allBillsUseCase.getAllBills(), BillDto.class)));
    }

}
