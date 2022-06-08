package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.dto.StockistDto;
import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IStockistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateStockistUseCase {

    private final IStockistRepository stockistRepo;

    private final ShopModelMapper mapper;

    private boolean validateFields(StockistDto stockistDto){
        return stockistDto.getStockistPersonalId() != null && stockistDto.getStockistName() != null
                && stockistDto.getPhoneNumber() != null;
    }

    private Mono<StockistDto> validateStockistDto(StockistDto stockistDto){
        return Mono.just(stockistDto)
                .filter(this::validateFields)
                .switchIfEmpty(Mono.error(()-> new Throwable("Some fields are empty")));
    }

    public Mono<StockistDto> createStockist(StockistDto stockistDto){
        return validateStockistDto(stockistDto)
                .flatMap((stockistDto1) -> stockistRepo.save(mapper.toStockistCollection(stockistDto)))
                        .map(mapper::toStockistDto);
    }
}
