package com.sofkaU.software.demo.usecases;


import com.sofkaU.software.demo.dto.StockistDto;
import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IStockistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllStockistsUseCase {

    private final IStockistRepository stockistRepo;

    private final ShopModelMapper mapper;

    public Flux<StockistDto> getAllStockists(){
        return  stockistRepo.findAll().map(mapper::toStockistDto);
    }
}
