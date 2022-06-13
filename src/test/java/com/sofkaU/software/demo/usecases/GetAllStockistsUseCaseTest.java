package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.collection.Stockist;
import com.sofkaU.software.demo.dto.StockistDto;
import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IStockistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class GetAllStockistsUseCaseTest {

    @Mock
    IStockistRepository stockistRepo;

    @Autowired
    ShopModelMapper mapper;

    private GetAllStockistsUseCase allStockistsUseCase;

    @BeforeEach
    void beforeEach(){
        allStockistsUseCase = new GetAllStockistsUseCase(stockistRepo, mapper);
    }

    @Test
    void getAllStockistTest(){
        Stockist stockist = new Stockist();
        stockist.setStockistId("1");
        stockist.setStockistName("Alan-brito");
        stockist.setStockistPersonalId("123dfg");
        stockist.setPhoneNumber("19542382");

        Mockito.when(stockistRepo.findAll()).thenReturn(Flux.just(stockist));
        Flux<StockistDto> stockistDtoFlux = allStockistsUseCase.getAllStockists();

        StepVerifier.create(stockistDtoFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(stockistRepo).findAll();
    }

}