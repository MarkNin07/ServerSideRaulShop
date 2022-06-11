package com.sofkaU.software.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductDto {

    private String productId;

    @NotBlank(message = "Product name cannot be blank")
    private String productName;

    @NotBlank(message = "Product price cannot be blank")
    private Integer price;

    @NotBlank(message = "Product description cannot be blank")
    private String description;

    @NotBlank(message = "Minimum product amount cannot be blank")
    private Integer minProdAmount;

    @NotBlank(message = "Maximum product amount cannot be blank")
    private Integer maxProdAmount;

    @NotBlank(message = "units available cannot be blank")
    private Integer unitsAvailable;

    @NotBlank(message = "Stockist name cannot be blank")
    private String stockistName;

}
