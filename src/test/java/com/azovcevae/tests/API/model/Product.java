package com.azovcevae.tests.API.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private String productId;
    private int amount;
    private double cost;
}

/*
        {"productId":400,
        "amount":1,
        "cost":2500},
 */