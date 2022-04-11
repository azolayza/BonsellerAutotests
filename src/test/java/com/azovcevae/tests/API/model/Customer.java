package com.azovcevae.tests.API.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    private Integer customerId;
    private String name;
    private String phoneLastDigits;
    private boolean isNewCustomer;
}
