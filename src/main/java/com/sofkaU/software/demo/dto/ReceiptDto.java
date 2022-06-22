package com.sofkaU.software.demo.dto;

import com.sofkaU.software.demo.collection.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ReceiptDto {

    private String receiptId;

    private Integer quantity;

    private String date;

    private Product product;

}
