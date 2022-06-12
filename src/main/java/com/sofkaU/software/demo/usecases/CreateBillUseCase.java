package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.dto.BillDto;
import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IBillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateBillUseCase {

    private final IBillRepository billRepo;

    private final ShopModelMapper mapper;

    private boolean validateBillFields(BillDto billDto){
        return billDto.getDate() != null &&
                billDto.getClientName() != null &&
                billDto.getSalesPerson() != null &&
                billDto.getTotalBill() != null &&
                billDto.getProductName() != null;
    }

    private Mono<BillDto> filterBillDto(BillDto billDto){
        return Mono.just(billDto)
                .filter(this::validateBillFields)
                .switchIfEmpty(Mono.error(()-> new Throwable("Some fields are empty")));
    }

    public Mono<BillDto> createBill(BillDto billDto){
        return filterBillDto(billDto)
                .flatMap(billDto1 -> billRepo.save(mapper.toBillCollection(billDto1)))
                .map(bill -> mapper.toBillDto(bill));
    }
}
