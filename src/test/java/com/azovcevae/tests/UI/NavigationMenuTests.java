package com.azovcevae.tests.UI;

import com.azovcevae.allure.JiraIssue;
import com.azovcevae.allure.Layer;
import com.azovcevae.allure.Microservice;
import com.azovcevae.helper.DriverUtils;
import com.azovcevae.pages.LoginPage;
import com.azovcevae.pages.MainPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("azovtsevae")
@Layer("ui")
@Microservice("BonSeller")
@JiraIssue("HOMEWORK-367")
@Feature("WEB-Navigation")
@DisplayName("Проверка навигации по страницам Bonseller через меню")
public class NavigationMenuTests extends TestBase {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    @Description("Тест проверяет команду Выход через главное меню и возврат на страницу атворизации")
    @DisplayName("Успешный выход из приложения")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void logoutSeller() {
        step("open dev.seller.bonpass.com and login", () ->
                loginPage.successLoginSeller());
        step("check identification block is visible", () ->
                mainPage.identificationShouldBeVisible());
        step("logout user from app", () ->
                mainPage.logoutSeller());
    }

    @Test
    @Description("Тест проверяет переход с главной страницы на страницу Истории")
    @DisplayName("Переход на страницу Истории через меню")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void goToHistoryPage() {
        step("open dev.seller.bonpass.com and login", () ->
                loginPage.successLoginSeller());
        step("open main menu", () ->
                mainPage.clickMenuIcon());
        step("select History and check page", () ->
                mainPage.goToHistoryPage());
    }

    @Test
    @Description("Тест проверяет переход с главной страницы на страницу Отчета")
    @DisplayName("Переход на страницу Отчета через меню")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void goToReportPage() {
        step("open dev.seller.bonpass.com and login", () ->
                loginPage.successLoginSeller());
        step("open main menu", () ->
                mainPage.clickMenuIcon());
        step("select Report and check page", () ->
                mainPage.goToReportPage());
    }

    @Test
    @Description("Тест проверяет переход с главной страницы на страницу Справки")
    @DisplayName("Переход на страницу Справки через меню")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void goToHelpPage() {
        step("open dev.seller.bonpass.com and login", () ->
                loginPage.successLoginSeller());
        step("open main menu", () ->
                mainPage.clickMenuIcon());
        step("select Help and check page", () ->
                mainPage.goToHelpPage());
    }

    @Test
    @Description("Тест проверяет ниличие ошибок в консоли с типом Error в авторизованном режиме на главной странице")
    @DisplayName("Лог консоли главной страницы в авторизованном режиме не содержит ошибок")
    void consoleShouldNotHaveErrorsMainPage() {
        step("open dev.seller.bonpass.com and login", () ->
                loginPage.successLoginSeller());

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
