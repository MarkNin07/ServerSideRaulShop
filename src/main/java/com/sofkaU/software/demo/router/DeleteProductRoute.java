package com.sofkaU.software.demo.router;


import com.sofkaU.software.demo.usecases.DeleteProductUseCase;
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
    public RouterFunction<ServerResponse> deleteProduct(DeleteProductUseCase deleteProd){
        return route(DELETE("/delete/product/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> deleteProd.deleteProduct(request.pathVariable("id"))
                        .flatMap((del)-> ServerResponse.status(HttpStatus.ACCEPTED).build())
                        .onErrorResume(e -> ServerResponse.status(HttpStatus.NOT_FOUND).build()));

    }

}
