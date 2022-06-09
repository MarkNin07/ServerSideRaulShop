package com.sofkaU.software.demo.usecases;


import com.sofkaU.software.demo.collection.Stockist;
import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IStockistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteStockistUseCase {

    private final IStockistRepository stockistRepo;

    private Mono<Stockist> findStockistById(String id){
        return stockistRepo.findById(id)
                .switchIfEmpty(Mono.error(() -> new Throwable("The ID has not been found")));
    }

    public Mono<Void> deleteStockist(String id){
        return findStockistById(id)
                .flatMap(stockist -> stockistRepo.deleteById(stockist.getStockistId()));
    }


}
