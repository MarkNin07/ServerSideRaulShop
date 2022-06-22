package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.collection.Product;
import com.sofkaU.software.demo.collection.Stockist;
import com.sofkaU.software.demo.dto.BillDto;
import com.sofkaU.software.demo.repository.IBillRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateBillUseCaseTest {

    @MockBean
    private CreateBillUseCase billUseCase;

    @Mock
    IBillRepository billRepo;

    @Test
    public void CreateBillTest(){

        Stockist stockist = new Stockist("123", "Alan-Brito", "JDL435", "1954879345");

        Stockist stockist2 = new Stockist("456", "MariaMal", "666DVIL", "1786543123");

        Product product = new Product("09812", "Hummer", 125, 0, "Silver hummer", 20, 100, 2, stockist);

        Product product2 = new Product("678345", "Screws", 10, 0, "iron screws", 50, 200, 100, stockist);

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);

        BillDto billDto = new BillDto("MNRS123", "22/06/2022", "Niela", "Raul", 150.0, products);

        StepVerifier.create(Mono.just(Mockito.when(billUseCase.createBill(billDto))
                .thenReturn(Mono.just(billDto))))
                .expectComplete();

    }

}