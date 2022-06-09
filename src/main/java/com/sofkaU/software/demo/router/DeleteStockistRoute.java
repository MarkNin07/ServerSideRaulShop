package com.sofkaU.software.demo.router;

import com.sofkaU.software.demo.usecases.DeleteStockistUseCase;
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
    public RouterFunction<ServerResponse> deleteStockist(DeleteStockistUseCase delStockist){
        return route(DELETE("/delete/stockist/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> delStockist.deleteStockist(request.pathVariable("id"))
                        .flatMap((del)-> ServerResponse.status(HttpStatus.ACCEPTED).build())
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.NOT_FOUND).build()));
    }
}
