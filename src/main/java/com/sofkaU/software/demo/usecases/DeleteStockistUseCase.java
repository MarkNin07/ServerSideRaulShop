package com.sofkaU.software.demo.usecases;


import com.sofkaU.software.demo.mapper.ShopModelMapper;
import com.sofkaU.software.demo.repository.IStockistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteStockistUseCase {

    private final IStockistRepository stockistRepo;

    private final ShopModelMapper mapper;



}
