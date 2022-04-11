package com.azovcevae.tests.API;

import com.azovcevae.allure.JiraIssue;
import com.azovcevae.allure.Layer;
import com.azovcevae.allure.Microservice;
import com.azovcevae.pages.ApiMethods;
import com.azovcevae.tests.API.model.Customer;
import com.azovcevae.tests.API.model.Order;
import com.azovcevae.tests.API.model.SellerProfile;
import com.azovcevae.tests.API.spec.BonSellerSpec;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.azovcevae.data.UsersData.SELLER_PASS;
import static com.azovcevae.data.UsersData.SELLER_W_PHONE;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Owner("azovtsevae")
@Layer("api")
@Microservice("BonSeller")
@JiraIssue("HOMEWORK-366")
@Feature("API-tests")
@DisplayName("Проверка методов Bonseller API")
public class BonSellerApiTests {
    ApiMethods api = new ApiMethods();
    String token = api.authorization(SELLER_W_PHONE, SELLER_PASS);
    String orderDetails = "{\"products\":[{\"productId\":749708,\"amount\":2,\"cost\":5600.0}],\"gifts\":[],\"customerId\":891}";

    @Test
    @Story("API тесты для web bonseller")
    @DisplayName("Проверка генерации токена во время логина")
    @Tags({@Tag("api"), @Tag("bonseller")})
    @Severity(SeverityLevel.BLOCKER)
    void SuccessGenerateBonsellerToken() {
        String data = "{\"login\":\"79009005050\",\"password\":\"2508\"}";
        given(BonSellerSpec.request)
                .body(data)
                .when()
                .post("/v1/login")
                .then()
                .spec(BonSellerSpec.responseSpec)
                .body(matchesJsonSchemaInClasspath("schemas/generateToken_response_shema.json"))
                .body("id", notNullValue())
                .body("token.size()", greaterThan(10));
    }

    @Test
    @Story("API тесты для web bonseller")
    @DisplayName("Проверка получения профиля кассира")
    @Tags({@Tag("api"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void getSellerProfile() {
        SellerProfile sellerProfile = given(BonSellerSpec.request)
                .when()
                .get("/v1/profile")
                .then()
                .statusCode(200)
                .extract().as(SellerProfile.class);
        assertEquals(291, sellerProfile.getId());
        assertThat(sellerProfile.getPosition()).isEqualTo("Администратор");
    }

    @Test
    @Story("API тесты для web bonseller")
    @DisplayName("Проверка получения плана продаж кассира")
    @Tags({@Tag("api"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void getSellerPlan() {
        given(BonSellerSpec.request)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/v1/plan")
                .then()
                .spec(BonSellerSpec.responseSpec)
                .body("newClientsPlan", notNullValue())
                .body("earningsPlan", notNullValue());
    }

    @Test
    @Story("API тесты для web bonseller")
    @DisplayName("Проверка получения списка скриптов для кассира")
    @Tags({@Tag("api"), @Tag("bonseller")})
    @Severity(SeverityLevel.TRIVIAL)
    void getSellerScripts() {
        given(BonSellerSpec.request)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/v1/scripts")
                .then()
                .spec(BonSellerSpec.responseSpec)
                .body(notNullValue());
    }

    @Test
    @Story("API тесты для web bonseller")
    @DisplayName("Проверка получения каталога продуктов заведения")
    @Tags({@Tag("api"), @Tag("bonseller")})
    @Severity(SeverityLevel.CRITICAL)
    void getProductsList() {
        given(BonSellerSpec.request)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/v1/products")
                .then()
                .spec(BonSellerSpec.responseSpec)
                .body("versionToken", notNullValue())
                .body("products", hasSize(greaterThan(0)));
    }

    @Test
    @Story("API тесты для web bonseller")
    @DisplayName("Проверка получения получения списка черновиков (сохраненных) чеков")
    @Tags({@Tag("api"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void getWaitingList() {
        given(BonSellerSpec.request)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/v1/payments/waiting")
                .then()
                .spec(BonSellerSpec.responseSpec)
                .body(notNullValue());
    }

    @Test
    @Story("API тесты для web bonseller")
    @DisplayName("Проверка получения истории продаж за выбранный период времени")
    @Tags({@Tag("api"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void getHistoryOnPeriod() {
        given(BonSellerSpec.request)
                .header("Authorization", "Bearer " + token)
                .param("pageSize", "10")
                .param("pageNumber", "1")
                .param("from", "2022-01-01")
                .param("to", "2022-04-01")
                .when()
                .get("/v1/history")
                .then()
                .spec(BonSellerSpec.responseSpec)
                .body("results", notNullValue());
    }

    @Test
    @Story("API тесты для web bonseller")
    @DisplayName("Проверка получения отчета по скидкам за выбранный период времени")
    @Tags({@Tag("api"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void getReportOnPeriod() {
        given(BonSellerSpec.request)
                .header("Authorization", "Bearer " + token)
                .param("from", "2022-01-01")
                .param("to", "2022-04-01")
                .when()
                .get("/v1/reports")
                .then()
                .spec(BonSellerSpec.responseSpec)
                .body("discountedProductsAmount", notNullValue())
                .body("totalDiscountPercentage", notNullValue())
                .body("totalDiscountAmount", notNullValue());
    }

    @Test
    @Story("API тесты для web bonseller")
    @DisplayName("Проверка получения информации о покупателе по номеру телефона")
    @Tags({@Tag("api"), @Tag("bonseller")})
    @Severity(SeverityLevel.CRITICAL)
    void searchCustomerByPhone() {
        String customerPhone = "79059050505";
        Customer customer =
                given(BonSellerSpec.request)
                        .header("Authorization", "Bearer " + token)
                        .param("is_code", "false")
                        .when()
                        .get("/v1/customers/search/" + customerPhone)
                        .then()
                        .spec(BonSellerSpec.responseSpec)
                        .extract().as(Customer.class);
        assertThat(customer.getPhoneLastDigits()).isEqualTo("0505");
        assertThat(customer.getName()).isEqualTo("Елизавета");
        ;
    }

    @Test
    @Story("API тесты для web bonseller")
    @DisplayName("Создание нового заказа для идентифицированного покупателя")
    @Tags({@Tag("api"), @Tag("bonseller")})
    @Severity(SeverityLevel.BLOCKER)
    void confirmedNewOrderWithCustomer() {
        given(BonSellerSpec.request)
                .header("Authorization", "Bearer " + token)
                .body(orderDetails)
                .when()
                .post("/v3.0/payments/confirmed")
                .then()
                .spec(BonSellerSpec.responseSpec)
                .body("paymentId", notNullValue())
                .body("status", is(3))
                .body("customer.customerId", is(891));
    }

    @Test
    @Story("API тесты для web bonseller")
    @DisplayName("Создание новой анонимной покупки без идентификации покупателя")
    @Tags({@Tag("api"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void confirmedNewOrderForAnonymous() {
        String orderDetails = "{\"products\":[{\"productId\":749708,\"amount\":2,\"cost\":5600.0}],\"gifts\":[]}";
        Order order =
                given(BonSellerSpec.request)
                        .header("Authorization", "Bearer " + token)
                        .body(orderDetails)
                        .when()
                        .post("/v3.0/payments/confirmed")
                        .then()
                        .spec(BonSellerSpec.responseSpec)
                        .extract().as(Order.class);
        assertThat(order.getStatus()).isEqualTo(3);
        assertThat(order.getAmountForPayment()).isEqualTo(11200.00);
    }

    @Test
    @Story("API тесты для web bonseller")
    @DisplayName("Создание черновика (status=2) заказа для идентифицированного покупателя")
    @Tags({@Tag("api"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void savedNewOrderWithCustomer() {
        Order order =
                given(BonSellerSpec.request)
                        .header("Authorization", "Bearer " + token)
                        .body(orderDetails)
                        .when()
                        .post("/v3.0/payments/saved")
                        .then()
                        .spec(BonSellerSpec.responseSpec)
                        .extract().as(Order.class);
        assertThat(order.getStatus()).isEqualTo(2);
        assertThat(order.getAmountForPayment()).isEqualTo(11200.00);
    }
}
