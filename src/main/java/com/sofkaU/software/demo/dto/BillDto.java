package com.sofkaU.software.demo.dto;

import com.sofkaU.software.demo.collection.Product;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;


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
    private Double totalBill;

    private List<Product> products;

}
