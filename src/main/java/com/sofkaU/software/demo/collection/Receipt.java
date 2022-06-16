package com.sofkaU.software.demo.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "receipt")
@Data
public class Receipt {

    @Id
    private String receiptId;

    private Integer quantity;

    private Product product;

    private String date;

}
