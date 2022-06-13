package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.dto.StockistDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CreateStockistUseCaseTest {

    @MockBean
    CreateStockistUseCase createStUseCase;

    @Test
    void createStockistUseCaseTest(){
        StockistDto stockistDto = new StockistDto();
        stockistDto.setStockistId("1");
        stockistDto.setStockistName("Alan");
        stockistDto.setStockistPersonalId("qwe456");
        stockistDto.setPhoneNumber("987564734");

        StepVerifier.create(Mono.just(Mockito.when(createStUseCase.createStockist(stockistDto))
                .thenReturn(Mono.just(stockistDto))))
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }

}