package com.azovcevae.tests.UI;

import com.azovcevae.allure.Layer;
import com.azovcevae.allure.Microservice;
import com.azovcevae.pages.WebElementsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Owner("azovtsevae")
@Layer("ui")
@Microservice("BonSeller")
@DisplayName("Проверка навигации по страницам Bonseller через меню")
public class NavigationMenuTests extends TestBaseUI {

    WebElementsPage bonsellerPage = new WebElementsPage();

    @Test
    @Description("Тест проверяет команду Выход через главное меню и возврат на страницу атворизации")
    @DisplayName("Успешный выход из приложения")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void logoutSeller() {
        step("open dev.seller.bonpass.com and login", () -> bonsellerPage.successLoginSeller());
        step("check identification block is visible", () -> bonsellerPage.identificationShouldBeVisible());
        step("logout user from app", () -> bonsellerPage.logoutSeller());
    }


    @Test
    @Description("Тест проверяет переход с главной страницы на страницу Истории")
    @DisplayName("Переход на страницу Истории через меню")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void goToHistoryPage() {
        step("open dev.seller.bonpass.com and login", () -> bonsellerPage.successLoginSeller());
        step("open main menu", () -> bonsellerPage.clickMenuIcon());
        step("select History and check page", () -> bonsellerPage.goToHistoryPage());
    }

    @Test
    @Description("Тест проверяет переход с главной страницы на страницу Отчета")
    @DisplayName("Переход на страницу Отчета через меню")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void goToReportPage() {
        step("open dev.seller.bonpass.com and login", () -> bonsellerPage.successLoginSeller());
        step("open main menu", () -> bonsellerPage.clickMenuIcon());
        step("select Report and check page", () -> bonsellerPage.goToReportPage());
    }

    @Test
    @Description("Тест проверяет переход с главной страницы на страницу Справки")
    @DisplayName("Переход на страницу Справки через меню")
    @Tags({@Tag("ui"), @Tag("bonseller")})
    @Severity(SeverityLevel.NORMAL)
    void goToHelpPage() {
        step("open dev.seller.bonpass.com and login", () -> bonsellerPage.successLoginSeller());
        step("open main menu", () -> bonsellerPage.clickMenuIcon());
        step("select Help and check page", () -> bonsellerPage.goToHelpPage());
    }
}
