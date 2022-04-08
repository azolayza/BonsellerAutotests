package com.azovcevae.tests.mobile;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class BonSellerAppTests {

    @Test
    @Disabled("With reason don't work it")
    void RunBonsellerTest() {
        $(AppiumBy.id("com.bonpass.seller.v2.dev:id/login_phone_number_edit_text"))
                .click();
        $(AppiumBy.id("com.bonpass.seller.v2.dev:id/login_phone_number_edit_text"))
                .setValue("9009005050");
        $(AppiumBy.id("com.bonpass.seller.v2.dev:id/login_password_edit_text"))
                .setValue("2508").pressEnter();
        $(AppiumBy.id("com.bonpass.seller.v2.dev:id/toolbarTitle"))
                .shouldHave(Condition.text("Потапова Полина"));

        System.out.println("App login is check");
    }
}
