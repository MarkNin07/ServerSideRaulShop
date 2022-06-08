package com.sofkaU.software.demo.collection;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "stockist")
@Data
public class Stockist {

    @Id
    private String stockistId;

    @NotBlank(message = "Stockist name cannot be blank")
    private String stockistName;

    @NotBlank(message = "Stockist personal ID cannot be blank")
    private String stockistPersonalId;

    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

}
