package com.sofkaU.software.demo.router;

import com.sofkaU.software.demo.dto.BillDto;
import com.sofkaU.software.demo.usecases.CreateBillUseCase;
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
