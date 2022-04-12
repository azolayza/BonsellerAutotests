package com.azovcevae.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    SelenideElement
            menuIcon = $(".nav-icon"),
            logoutIcon = $(byText("Выход")),
            loginInput = $(".text-input"),
            identification = $(".identification"),
            historyIcon = $(byText("История операций")),
            historyBlock = $(".scrollable"),
            reportIcon = $(byText("Отчет")),
            helpIcon = $(byText("Справка")),
            helpPageBlock = $(".reference-wrapper");

    public MainPage logoutSeller() {
        menuIcon.click();
        logoutIcon.click();
        loginInput.shouldHave(text("Логин продавца"));
        return this;
    }

    public MainPage identificationShouldBeVisible() {
        identification.shouldHave(text("Идентификация клиента"));
        return this;
    }

    public MainPage clickMenuIcon() {
        menuIcon.click();
        return this;
    }

    public MainPage goToHistoryPage() {
        historyIcon.click();
        historyBlock.shouldHave(text("История операций"));
        return this;
    }

    public MainPage goToReportPage() {
        reportIcon.click();
        historyBlock.shouldHave(text("Отчет"));
        return this;
    }

    public MainPage goToHelpPage() {
        helpIcon.click();
        helpPageBlock.shouldHave(text("Инструкция по работе с BonSeller"));
        return this;
    }
}

