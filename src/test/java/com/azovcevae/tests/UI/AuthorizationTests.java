package com.azovcevae.tests.UI;

import com.azovcevae.allure.JiraIssue;
import com.azovcevae.allure.Layer;
import com.azovcevae.allure.Microservice;
import com.azovcevae.pages.WebElementsPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Owner("azovtsevae")
@Layer("ui")
@Microservice("BonSeller")
@JiraIssue("HOMEWORK-367")
@Feature("WEB-Authorization")
@DisplayName("Проверка Bonseller веб авторизации")
public class AuthorizationTests extends TestBase {
    WebElementsPage webElementsPage = new WebElementsPage();

   @Test
   @Description("Тест проверяет авторизацию продавца в приложении Веб Бонселлер по номеру телефона и коду авторизации)")
   @DisplayName("Проверка успешной авторизации")
   @Tags({@Tag("ui"), @Tag("bonseller")})
   @Severity(SeverityLevel.BLOCKER)
   void successLogin() {
       step("open dev.seller.bonpass.com and login", () ->
               webElementsPage.successLoginSeller());
       step("check name user in navbar", () ->
               webElementsPage.nameSellerShouldBeVisible());
    }

    @Test
    @Description("Тест проверяет, что невозможно нажать на Войти не введя номер телефона")
    @DisplayName("Проверка недоступности кнопки Войти без номера телефона")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void unavailableLoginWithoutPhone() {
        step("open https://dev.seller.bonpass.com/login", () ->
                webElementsPage.openPage());
        step("check Submit button unavailable in login page", () -> {
            $(by("type", "password")).setValue("2508");
            $(".button").shouldBe(disabled);
        });
    }

    @Test
    @Description("Тест проверяет, что невозможно нажать на Войти не введя пароль")
    @DisplayName("Кнопка Войти недоступна без пароля")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void unavailableLoginWithoutPass() {
        step("open https://dev.seller.bonpass.com/login", () ->
                webElementsPage.openPage());
        step("check Submit button unavailable in login page", () -> {
            $(by("type", "tel")).setValue("9009005050");
            $(".button").shouldBe(disabled);
        });
    }

    @Test
    @Description("Тест проверяет ошибку авторизации с неверным номером телефона")
    @DisplayName("Ошибка авторизации с неверным телефоном")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.TRIVIAL)
    void negativeLoginWithInvalidPhone() {
        step("open https://dev.seller.bonpass.com/login", () ->
                webElementsPage.openPage());
        step("login user with incorrect password", () ->
                webElementsPage.loginSellerWithIncorrectPhone());
        step("check error dialog", () ->
                webElementsPage.errorOfLoginAlert());
    }

    @Test
    @Description("Тест проверяет ошибку авторизации с неверным паролем")
    @DisplayName("Ошибка авторизации с неверным паролем")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.TRIVIAL)
    void negativeLoginWithInvalidPass() {
        step("open https://dev.seller.bonpass.com/login", () ->
                webElementsPage.openPage());
        step("login user with incorrect password", () ->
                webElementsPage.loginSellerWithIncorrectPass());
        step("check error dialog", () ->
                webElementsPage.errorOfLoginAlert());
    }
}