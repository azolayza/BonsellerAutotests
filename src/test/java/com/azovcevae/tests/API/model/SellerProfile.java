package com.azovcevae.tests.API.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class SellerProfile {
        private Integer id;
        private String fullName;
        private String position;
        private double rate;
        private boolean hasCashAccess;
    }