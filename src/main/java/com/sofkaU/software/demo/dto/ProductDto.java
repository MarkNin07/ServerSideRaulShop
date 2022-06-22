package com.sofkaU.software.demo.dto;

import com.sofkaU.software.demo.collection.Stockist;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class ProductDto {

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
