package com.azovcevae.pages;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiMethods {

    public String authorization(String login, String pass) {
        Map<String, String> seller = new HashMap<>();
        seller.put("login", login);
        seller.put("password", pass);

        Response response = (Response) given().relaxedHTTPSValidation()
                .contentType("application/json")
                .body(seller)
                .when()
                .post("https://kvqc57eyx7.execute-api.eu-central-1.amazonaws.com/dev/api/v1/login")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.get("token");
        return token;
    }


}
