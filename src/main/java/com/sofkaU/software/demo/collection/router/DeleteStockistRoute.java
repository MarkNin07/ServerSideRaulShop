package com.sofkaU.software.demo.collection.router;

import com.sofkaU.software.demo.dto.StockistDto;
import com.sofkaU.software.demo.usecases.DeleteStockistUseCase;
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
public class DeleteStockistRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "Delete stockist ", operationId = "delete stockist", tags = "Stockist",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = StockistDto.class)))))
    public RouterFunction<ServerResponse> deleteStockist(DeleteStockistUseCase delStockist){
        return route(DELETE("/delete/stockist/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> delStockist.deleteStockist(request.pathVariable("id"))
                        .flatMap((del)-> ServerResponse.status(HttpStatus.ACCEPTED).build())
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.NOT_FOUND).build()));
    }
}
