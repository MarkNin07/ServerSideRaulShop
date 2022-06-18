package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.dto.ProductDto;
import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateProductUseCase {

    private final IProductRepository productRepo;

    private final ShopModelMapper mapper;

    private boolean validateProdFields(ProductDto productDto){
        return productDto.getProductName() != null &&
                productDto.getPrice() != null &&
                productDto.getDescription() != null &&
                productDto.getMinProdAmount() != null &&
                productDto.getMaxProdAmount() != null &&
                productDto.getUnitsAvailable() != null &&
                productDto.getStockist() != null;
    }

    private Mono<ProductDto> filterProductDto(ProductDto productDto){
        return Mono.just(productDto)
                .filter(this::validateProdFields)
                .switchIfEmpty(Mono.error(()-> new Throwable("Some fields are empty")));
    }

    public Mono<ProductDto> createProduct(ProductDto productDto){
        return filterProductDto(productDto)
                .flatMap((prodDto) -> productRepo.save(mapper.toProductCollection(productDto)))
                .map(mapper::toProductDto);
    }
}
