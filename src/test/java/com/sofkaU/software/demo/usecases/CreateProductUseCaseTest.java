package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CreateProductUseCaseTest {

    @MockBean
    CreateProductUseCase createProdUseCase;

    @Test
    void createProductUseCaseTest(){
        ProductDto productDto = new ProductDto();
        productDto.setProductId("1");
        productDto.setProductName("Hammer");
        productDto.setPrice(5);
        productDto.setDescription("silver");
        productDto.setMinProdAmount(5);
        productDto.setMaxProdAmount(50);
        productDto.setUnitsAvailable(25);
        productDto.setStockistName("Rodolf");

        StepVerifier.create(Mono.just(Mockito.when(createProdUseCase.createProduct(productDto))
                .thenReturn(Mono.just(productDto))))
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }

}