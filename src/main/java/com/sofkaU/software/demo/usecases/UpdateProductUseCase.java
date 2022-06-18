package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.dto.ProductDto;
import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class UpdateProductUseCase {

    private final IProductRepository productRepo;

    private final ShopModelMapper mapper;

    public Mono<ProductDto> updateProd(ProductDto productDto){
        return productRepo.save(mapper.toProductCollection(productDto))
                .map(mapper::toProductDto);
    }
}
