package com.azovcevae.tests.API.spec;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class BonSellerSpec {
    public static RequestSpecification request = with()
            .filter(new AllureRestAssured())
            .baseUri("https://kvqc57eyx7.execute-api.eu-central-1.amazonaws.com")
            .basePath("/dev/api")
            .log().all()
            .contentType("application/json");

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
