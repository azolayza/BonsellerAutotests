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
