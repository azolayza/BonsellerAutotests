package com.azovcevae.tests.API.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    private Integer paymentId;
    private String paymentPublicId;
    private double totalAmount;
    private double amountForPayment;
    private Integer status;
    private Integer paymentMethod;
    private String created;
    private boolean confirmationRequired;
}
/*
{
    "paymentId": 8235,
    "paymentPublicId": "18931e58-c84c-4849-8fb5-2166c7670811",
    "cashReceiptId": null,
    "totalAmount": 11200.0,
    "discountAmount": 0.0,
    "amountForPayment": 11200.0,
    "customerCashbackAmount": null,
    "status": 3,
    "paymentMethod": 0,
    "gifts": [],
    "rolledBackAmount": 0.0,
    "products": [
        {
            "amount": 2.0,
            "rolledBackAmount": 0.0,
            "cashbackAmount": 0,
            "product": {
                "id": 749708,
                "name": "Биоревитализация",
                "measureName": null,
                "cost": 5600.0,
                "discountedCost": 5600.0,
                "externalCode": null
            }
        }
    ],
    "totalGiftCost": 0,
    "created": "2022-04-07T07:32:39.186527",
    "confirmationRequired": false,
    "customer": {
        "customerId": 891,
        "name": "Alena",
        "phoneLastDigits": "0000"
    },
    "finalCosts": [
        {
            "product": {
                "id": 749708,
                "name": "Биоревитализация",
                "measureName": null,
                "cost": 5600.0,
                "discountedCost": 5600.0,
                "externalCode": null
            },
            "amount": 2.0
        }
    ]
}
 */
