package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.collection.Product;
import com.sofkaU.software.demo.dto.ProductDto;
import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IProductRepository;
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
class GetAllProductsUseCaseTest {

    @Mock
    IProductRepository productRepo;

    @Autowired
    ShopModelMapper mapper;

    private GetAllProductsUseCase getAllProdUseCase;

    @BeforeEach
    void beforeEach(){
        getAllProdUseCase = new GetAllProductsUseCase(productRepo, mapper);
    }

    @Test
    void getAllProductsTest(){
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("drill");
        product.setPrice(50);
        product.setDescription("blue");
        product.setMinProdAmount(10);
        product.setMaxProdAmount(50);
        product.setUnitsAvailable(20);
        product.setStockistName("Alan-brito");

        Mockito.when(productRepo.findAll()).thenReturn(Flux.just(product));
        Flux<ProductDto> productDtoFlux = getAllProdUseCase.getAllProducts();

        StepVerifier.create(productDtoFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(productRepo).findAll();
    }

}