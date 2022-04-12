package com.azovcevae.tests.API.spec;

import com.azovcevae.pages.ApiMethods;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import static com.azovcevae.data.SellerData.SELLER_PASS;
import static com.azovcevae.data.SellerData.SELLER_W_PHONE;
import static io.restassured.RestAssured.with;

public class BonSellerSpec {
    @BeforeAll
    static String generateToken() {
        ApiMethods api = new ApiMethods();
        String token = api.authorization(SELLER_W_PHONE, SELLER_PASS);
        return token;
    }

    public static RequestSpecification request = with()
            .filter(new AllureRestAssured())
            .baseUri("https://kvqc57eyx7.execute-api.eu-central-1.amazonaws.com")
            .header("Authorization", "Bearer " + generateToken())
            .basePath("/dev/api")
            .log().all()
            .contentType("application/json");

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
