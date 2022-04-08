package com.azovcevae.pages;

import com.azovcevae.tests.UI.TestBaseUI;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.azovcevae.data.UsersData.*;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebElementsPage extends TestBaseUI {

    SelenideElement
        //login = $(byAttribute("type", "tel")),
        login = $("[type='tel']"),
        password = $(byAttribute("type", "password")),
        submitLogin = $(".button"),
        ratingIcon = $(".rating"),
        profileName = $(".profile"),
        errorDialog = $(".error-dialog"),
        menuIcon = $(".nav-icon"),
        logoutIcon = $(byText("Выход")),
        loginInput = $(".text-input"),
        identification = $(".identification"),
        historyIcon = $(byText("История операций")),
        historyBlock = $(".scrollable"),
        reportIcon = $(byText("Отчет")),
        helpIcon = $(byText("Справка")),
        helpPageBlock = $(".reference-wrapper");

    public WebElementsPage openPage(){
        open("https://dev.seller.bonpass.com/login");
        return this;
    }

    public WebElementsPage loginSeller() {
        open("https://dev.seller.bonpass.com/login");
        login.click();
        login.setValue(SELLER_PHONE);
        password.setValue(SELLER_PASS);
        submitLogin.click();
        ratingIcon.should(appear, Duration.ofSeconds(30));
        return this;
    }

    public WebElementsPage loginSellerWithIncorrectPass() {
        open("https://dev.seller.bonpass.com/login");
        login.click();
        login.setValue(SELLER_PHONE);
        password.setValue(SELLER_PASS_INCORRECT);
        submitLogin.click();
        return this;
    }

    public WebElementsPage loginSellerWithIncorrectPhone() {
        open("https://dev.seller.bonpass.com/login");
        login.click();
        login.setValue(SELLER_PHONE_INCORRECT);
        password.setValue(SELLER_PASS);
        submitLogin.click();
        return this;
    }

    public WebElementsPage nameSellerShouldBeVisible(){
        profileName.shouldHave(text("Потапова Полина"));
        return this;
    }

    public WebElementsPage errorOfLoginAlert(){
        errorDialog.should(appear, Duration.ofSeconds(30));
        errorDialog.shouldHave(text("Неверный логин или пароль. " +
                        "Используйте ваш номер телефона и выданный пароль для входа"));
        return this;
    }

    public WebElementsPage logoutSeller(){
        menuIcon.click();
        logoutIcon.click();
        loginInput.shouldHave(text("Логин продавца"));
        return this;
    }

    public WebElementsPage identificationShouldBeVisible(){
        identification.shouldHave(text("Идентификация клиента"));
        return this;
    }

    public WebElementsPage clickMenuIcon(){
        menuIcon.click();
        return this;
    }

    public WebElementsPage goToHistoryPage(){
        historyIcon.click();
        historyBlock.shouldHave(text("История операций"));
        return this;
    }

    public WebElementsPage goToReportPage(){
        reportIcon.click();
        historyBlock.shouldHave(text("Отчет"));
        return this;
    }
    public WebElementsPage goToHelpPage() {
        helpIcon.click();
        helpPageBlock.shouldHave(text("Инструкция по работе с BonSeller"));
        return this;
    }

    public WebElementsPage successLoginSeller() {
    openPage();
    loginSeller();
    return this;}
}

