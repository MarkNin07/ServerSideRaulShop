package com.sofkaU.software.demo.usecases;


import com.sofkaU.software.demo.dto.ReceiptDto;
import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllReceiptsUseCase {

    private final IReceiptRepository receiptRepo;

    private final ShopModelMapper mapper;

    public Flux<ReceiptDto> getAllReceipts(){
        return receiptRepo.findAll().map(mapper::toReceiptDto);
    }

}
