package com.sofkaU.software.demo.usecases;

import com.sofkaU.software.demo.dto.BillDto;
import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IBillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllBillsUseCase {

    private final IBillRepository billRepo;

    private final ShopModelMapper mapper;

    public Flux<BillDto> getAllBills(){
        return billRepo.findAll().map(mapper::toBillDto);
    }
}
