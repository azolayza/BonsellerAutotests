package com.azovcevae.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.azovcevae.data.UsersData.*;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    SelenideElement
            login = $("[type='tel']"),
            password = $(by("type", "password")),
            submitLogin = $(".button"),
            ratingIcon = $(".rating"),
            profileName = $(".profile"),
            errorDialog = $(".error-dialog");

    public LoginPage openPage() {
        open("/login");
        return this;
    }

    public LoginPage loginSeller() {
        open("/login");
        login.click();
        login.setValue(SELLER_PHONE);
        password.setValue(SELLER_PASS);
        submitLogin.click();
        ratingIcon.should(appear, Duration.ofSeconds(30));
        return this;
    }

    public LoginPage loginSellerWithIncorrectPass() {
        open("/login");
        login.click();
        login.setValue(SELLER_PHONE);
        password.setValue(SELLER_PASS_INCORRECT);
        submitLogin.click();
        return this;
    }

    public LoginPage loginSellerWithIncorrectPhone() {
        open("/login");
        login.click();
        login.setValue(SELLER_PHONE_INCORRECT);
        password.setValue(SELLER_PASS);
        submitLogin.click();
        return this;
    }

    public LoginPage successLoginSeller() {
        openPage();
        loginSeller();
        return this;
    }
    public LoginPage nameSellerShouldBeVisible() {
        profileName.shouldHave(text(SELLER_NAME));
        return this;
    }

    public LoginPage errorOfLoginAlert() {
        errorDialog.should(appear, Duration.ofSeconds(30));
        errorDialog.shouldHave(text("Неверный логин или пароль. " +
                "Используйте ваш номер телефона и выданный пароль для входа"));
        return this;
    }
}
