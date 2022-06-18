package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.dto.ReceiptDto;
import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateReceiptUseCase {

    private final IReceiptRepository receiptRepo;

    private final ShopModelMapper mapper;

    private boolean validateReceiptFields(ReceiptDto receiptDto){
        return true;
    }

    private Mono<ReceiptDto> filterReceiptDto(ReceiptDto receiptDto){
        return Mono.just(receiptDto)
                .filter(this::validateReceiptFields)
                .switchIfEmpty(Mono.error(()-> new Throwable("Some fields are empty")));
    }

    public Mono<ReceiptDto> createReceipt(ReceiptDto receiptDto){
        return filterReceiptDto(receiptDto)
                .flatMap((receiptDto1 -> receiptRepo.save(mapper.toReceiptCollection(receiptDto1))))
                .map(mapper::toReceiptDto);
    }


}
