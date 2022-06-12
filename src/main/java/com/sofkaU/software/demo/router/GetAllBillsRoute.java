package com.sofkaU.software.demo.router;

import com.sofkaU.software.demo.dto.BillDto;
import com.sofkaU.software.demo.usecases.GetAllBillsUseCase;
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
    public RouterFunction<ServerResponse> AllBills (GetAllBillsUseCase allBillsUseCase){
        return route(GET("/get/all/bills"), request -> ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromProducer(allBillsUseCase.getAllBills(), BillDto.class)));
    }

}
