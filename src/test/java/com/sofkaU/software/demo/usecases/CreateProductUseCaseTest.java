package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.collection.Product;
import com.sofkaU.software.demo.collection.Stockist;
import com.sofkaU.software.demo.dto.ProductDto;
import com.sofkaU.software.demo.repository.IProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateProductUseCaseTest {

    @MockBean
    private CreateProductUseCase productUseCase;

    @Mock
    IProductRepository productRepo;

    @Test
    public void createStockistTest(){

        Stockist stockist = new Stockist("1", "Elle", "T35T", "1756483129");

        Product product = new Product("P1", "screws", 10, 0, "iron screws", 50, 250, 100, stockist);

        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setPrice(product.getPrice());
        productDto.setSold(product.getSold());
        productDto.setMinProdAmount(product.getMinProdAmount());
        productDto.setMaxProdAmount(product.getMaxProdAmount());
        productDto.setUnitsAvailable(product.getUnitsAvailable());
        productDto.setStockist(product.getStockist());

        StepVerifier.create(Mono.just(Mockito.when(productUseCase.createProduct(productDto))
                .thenReturn(Mono.just(productDto))))
                .expectComplete();

    }

}