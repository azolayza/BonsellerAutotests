package com.azovcevae.tests.UI;

import com.azovcevae.allure.JiraIssue;
import com.azovcevae.allure.Layer;
import com.azovcevae.allure.Microservice;
import com.azovcevae.helper.DriverUtils;
import com.azovcevae.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("azovtsevae")
@Layer("ui")
@Microservice("BonSeller")
@JiraIssue("HOMEWORK-367")
@Feature("WEB-Authorization")
@DisplayName("Проверка Bonseller веб авторизации")
public class AuthorizationTests extends TestBase {
    LoginPage loginPage = new LoginPage();

   @Test
   @Description("Тест проверяет авторизацию продавца в приложении Веб Бонселлер по номеру телефона и коду авторизации)")
   @DisplayName("Проверка успешной авторизации")
   @Tags({@Tag("ui"), @Tag("bonseller")})
   @Severity(SeverityLevel.BLOCKER)
   void successLogin() {
       step("open dev.seller.bonpass.com and login", () ->
               loginPage.successLoginSeller());
       step("check name user in navbar", () ->
               loginPage.nameSellerShouldBeVisible());
    }

    @Test
    @Description("Тест проверяет, что невозможно нажать на Войти не введя номер телефона")
    @DisplayName("Проверка недоступности кнопки Войти без номера телефона")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void unavailableLoginWithoutPhone() {
        step("open https://dev.seller.bonpass.com/login", () ->
                loginPage.openPage());
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
                loginPage.openPage());
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
                loginPage.openPage());
        step("login user with incorrect password", () ->
                loginPage.loginSellerWithIncorrectPhone());
        step("check error dialog", () ->
                loginPage.errorOfLoginAlert());
    }

    @Test
    @Description("Тест проверяет ошибку авторизации с неверным паролем")
    @DisplayName("Ошибка авторизации с неверным паролем")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.TRIVIAL)
    void negativeLoginWithInvalidPass() {
        step("open https://dev.seller.bonpass.com/login", () ->
                loginPage.openPage());
        step("login user with incorrect password", () ->
                loginPage.loginSellerWithIncorrectPass());
        step("check error dialog", () ->
                loginPage.errorOfLoginAlert());
    }

    @Test
    @Description("Тест проверяет ниличие ошибок в консоли с типом Error")
    @DisplayName("Лог консоли страницы логина не содержит ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://dev.seller.bonpass.com/login'", () ->
                loginPage.openPage());

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}