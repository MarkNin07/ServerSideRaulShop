package com.sofkaU.software.demo.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Document(collection = "product")
@Data
@AllArgsConstructor
public class Product {

    @Id
    private String productId;

    @NotBlank(message = "Product name cannot be blank")
    private String productName;

    @NotBlank(message = "Product price cannot be blank")
    private Integer price;

    private Integer sold;

    @NotBlank(message = "Product description cannot be blank")
    private String description;

    @NotBlank(message = "Minimum product amount cannot be blank")
    private Integer minProdAmount;

    @NotBlank(message = "Maximum product amount cannot be blank")
    private Integer maxProdAmount;

    @NotBlank(message = "units available cannot be blank")
    private Integer unitsAvailable;

    private Stockist stockist;

}
