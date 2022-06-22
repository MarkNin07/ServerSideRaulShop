package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.collection.Bill;
import com.sofkaU.software.demo.collection.Product;
import com.sofkaU.software.demo.collection.Stockist;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetAllBillsUseCaseTest {

    private GetAllBillsUseCase allBillsUseCase;

    @Autowired
    private ShopModelMapper mapper;

    @Mock
    IBillRepository billRepo;

    @BeforeEach
    void setUp(){
        allBillsUseCase = new GetAllBillsUseCase(billRepo, mapper);
    }

    @Test
    void getAllBillsTest (){

        Stockist stockist = new Stockist("S3", "Hellen", "SH345", "1345678905");

        Stockist stockist2 = new Stockist("S4", "Ellen", "SE543", "1954345098");

        Product product = new Product("P1", "product1", 100, 0, "x-product", 10, 100, 15, stockist);

        Product product2= new Product("P2", "product2", 99, 0, "y-product", 9, 99, 19, stockist2);

        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(product);
        listOfProducts.add(product2);

        Bill bill = new Bill("BI890", "12/01/2001", "Annie", "Raul", 200.0, listOfProducts);

        Stockist stockist3 = new Stockist("S5", "Llen", "SL435", "135678098");

        Stockist stockist4 = new Stockist("S6", "Len", "SLe453", "1987564203");

        Product product3 = new Product("idproduct3","Product name",50,0,"xproductx", 20,50, 25, stockist3);

        Product product4 = new Product("idproduct4","another name",50,0,"xproducty", 20,50, 25, stockist4);

        List<Product> listOfProducts2 = new ArrayList<>();
        listOfProducts2.add(product3);
        listOfProducts2.add(product4);

        Bill bill2 = new Bill("B980", "30/03/2022", "Aria", "Raul", 230.0, listOfProducts2);

        Mockito.when(billRepo.findAll()).thenReturn(Flux.just(bill, bill2));
        Flux<BillDto> flux = allBillsUseCase.getAllBills();

        StepVerifier.create(flux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(billRepo).findAll();

    }

}