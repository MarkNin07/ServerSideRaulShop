package com.sofkaU.software.demo.collection.router;


import com.sofkaU.software.demo.dto.StockistDto;
import com.sofkaU.software.demo.usecases.GetAllStockistsUseCase;
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
public class GetAllStockistRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "All stockist ", operationId = "get all stockists", tags = "Stockist",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = StockistDto.class)))))
    public RouterFunction<ServerResponse> AllStockist(GetAllStockistsUseCase allStockists){
        return route(GET("/get/all/stockists"), request -> ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromProducer(allStockists.getAllStockists(), StockistDto.class)));
    }

}
