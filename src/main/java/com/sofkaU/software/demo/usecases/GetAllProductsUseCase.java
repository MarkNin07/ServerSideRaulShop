package com.sofkaU.software.demo.usecases;


import com.sofkaU.software.demo.dto.ProductDto;
import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllProductsUseCase {

    private final IProductRepository productRepo;

    private final ShopModelMapper mapper;

    public Flux<ProductDto> getAllProducts(){
        return productRepo.findAll().map(mapper::toProductDto);
    }

}
