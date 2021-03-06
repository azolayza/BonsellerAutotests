package com.azovcevae.tests.API.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    @JsonProperty("products")
    private Integer customerId;
    private Product[] products;
}

