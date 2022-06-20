package com.sofkaU.software.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StockistDto {

    private String stockistId;

    @NotBlank(message = "Stockist name cannot be empty")
    private String stockistName;

    @NotBlank(message = "Stockist personal ID cannot be blank")
    private String stockistPersonalId;

    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber; 

}
