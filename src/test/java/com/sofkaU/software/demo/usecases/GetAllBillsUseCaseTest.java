package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.collection.Bill;
import com.sofkaU.software.demo.dto.BillDto;
import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IBillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetAllBillsUseCaseTest {

    @Mock
    IBillRepository billRepo;

    @Autowired
    ShopModelMapper mapper;

    private GetAllBillsUseCase getAllBills;

    @BeforeEach
    void beforeEach(){
        getAllBills = new GetAllBillsUseCase(billRepo, mapper);
    }

    @Test
    public void getAllBillsTest() {
        Map<String, Integer> product = new HashMap<>();
        product.put("product1", 1);
        product.put("product2", 2);

        Bill bill = new Bill();

        bill.setBillId("7");
        bill.setDate("12-12-28");
        bill.setClientName("Niela");
        bill.setSalesPerson("Anjo");
        bill.setTotalBill(90);
        bill.setProductName("Hummer");

        Mockito.when(billRepo.findAll()).thenReturn(Flux.just(bill));

        Flux<BillDto> billDtoFlux = getAllBills.getAllBills();

        StepVerifier.create(billDtoFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(billRepo).findAll();

    }


}