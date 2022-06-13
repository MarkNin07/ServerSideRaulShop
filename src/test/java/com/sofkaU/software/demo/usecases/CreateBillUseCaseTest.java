package com.sofkaU.software.demo.usecases;


import com.sofkaU.software.demo.dto.BillDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CreateBillUseCaseTest {

    @MockBean
    CreateBillUseCase createBillUseCase;

    @Test
    void createBillUseCaseTest(){
        BillDto billDto = new BillDto();
        billDto.setBillId("1");
        billDto.setDate("2001-04-01");
        billDto.setClientName("Elizabeth");
        billDto.setSalesPerson("Zergyo");
        billDto.setTotalBill(75);
        billDto.setProductName("Hummer");

        StepVerifier.create(Mono.just(Mockito.when(createBillUseCase.createBill(billDto))
                .thenReturn(Mono.just(billDto))))
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }

}