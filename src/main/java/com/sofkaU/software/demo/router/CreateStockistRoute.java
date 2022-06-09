package com.sofkaU.software.demo.router;


import com.sofkaU.software.demo.dto.StockistDto;
import com.sofkaU.software.demo.usecases.CreateStockistUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateStockistRoute {

    @Bean
    public RouterFunction<ServerResponse> createStockist(CreateStockistUseCase createStockist){
        return route(POST("/create/stockist").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(StockistDto.class)
                        .flatMap(createStockist::createStockist)
                        .flatMap(stockistDto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(createStockist))
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.BAD_REQUEST).build()));
    }
}
