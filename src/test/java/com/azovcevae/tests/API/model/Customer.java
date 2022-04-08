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

/*
{
    "customerId": 4594,
    "name": "Елизавета",
    "phoneLastDigits": "0505",
    "balance": {
        "amount": 2687
    },
    "status": {
        "name": "Профи клиент",
        "cashback": 25.0
    },
    "inviterCanBeSet": false,
    "isNewCustomer": false
}
 */
