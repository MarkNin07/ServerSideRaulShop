package com.sofkaU.software.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class BillDto {

    private String billId;

    @NotBlank(message = "Date cannot be blank")
    private String date;

    @NotBlank(message = "client cannot be blank")
    private String clientName;

    @NotBlank(message = "Sales person cannot be blank")
    private String salesPerson;

    @NotBlank(message = "Total bill cannot be blank")
    private String totalBill;

    @NotBlank(message = "Product cannot be blank")
    private String productId;

    @NotBlank(message = "Product name cannot be blank")
    private String productName;

}
