package com.sofkaU.software.demo.collection;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Document (collection = "bill")
@Data
public class Bill {

    @Id
    private String id;

    @NotBlank(message = "Date cannot be blank")
    private String date;

    @NotBlank(message = "client cannot be blank")
    private String client;

    @NotBlank(message = "Sales person cannot be blank")
    private String salesPerson;

    @NotBlank(message = "Total bill cannot be blank")
    private String totalBill;

    @NotBlank(message = "Product cannot be blank")
    private List<Product> productList;

}
