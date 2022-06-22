package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.collection.Stockist;
import com.sofkaU.software.demo.dto.StockistDto;
import com.sofkaU.software.demo.repository.IStockistRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateStockistUseCaseTest {

    @MockBean
    private CreateStockistUseCase stockistUseCase;

    @Mock
    IStockistRepository stockistRepo;

    @Test
    public void CreateStockistTest(){

        Stockist stockist = new Stockist("S2", "Json", "SJ001", "1954345234");

        StockistDto stockistDto = new StockistDto();
        stockistDto.setStockistId(stockist.getStockistId());
        stockistDto.setStockistName(stockist.getStockistName());
        stockistDto.setStockistPersonalId(stockist.getStockistPersonalId());
        stockistDto.setPhoneNumber(stockist.getPhoneNumber());

        StepVerifier.create(Mono.just(Mockito.when(stockistUseCase.createStockist(stockistDto))
                .thenReturn(Mono.just(stockistDto))))
                .expectComplete();
    }

}