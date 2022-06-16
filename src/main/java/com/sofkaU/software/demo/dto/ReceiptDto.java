package com.sofkaU.software.demo.dto;

import com.sofkaU.software.demo.collection.Product;
import lombok.Data;

@Data
public class ReceiptDto {

    private String receiptId;

    private Integer quantity;

    private Product product;

    private String date;
}
