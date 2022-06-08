package com.sofkaU.software.demo.collection;

import lombok.Data;

import java.util.List;


public class Product {

    private String productName;

    private Long price;

    private String description;

    private Integer minProdAmount;

    private Integer maxProdAmount;

    private Integer amountAvailable;

    private Stockist stockist;

    public Product(String productName, Long price, String description,
                   Integer minProdAmount, Integer maxProdAmount,
                   Integer amountAvailable, Stockist stockist) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.minProdAmount = minProdAmount;
        this.maxProdAmount = maxProdAmount;
        this.amountAvailable = amountAvailable;
        this.stockist = stockist;
    }



}
