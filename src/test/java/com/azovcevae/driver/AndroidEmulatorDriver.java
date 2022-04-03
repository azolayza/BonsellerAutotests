package com.azovcevae.driver;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

@Disabled
@ParametersAreNonnullByDefault
public class AndroidEmulatorDriver implements WebDriverProvider {
    @Override
    @CheckReturnValue
    @Nonnull
    public WebDriver createDriver(Capabilities capabilities) {
        File app = new File("resources/apk/bonseller-2.0.27-dev-release.apk");

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        options.setDeviceName("Android11-6");
        options.setPlatformVersion("11.0");
        options.setApp(app.getAbsolutePath());
        options.setLocale("en");
        options.setLanguage("en");
        options.setAppPackage("com.bonpass.seller.v2.dev");
        options.setAppActivity("com.bonpass.seller.screens.login.LoginActivity");

        try {
            return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
