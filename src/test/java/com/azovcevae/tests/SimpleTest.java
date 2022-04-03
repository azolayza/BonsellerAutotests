package com.azovcevae.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class SimpleTest {
    private AppiumDriver driver;
    @BeforeEach
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","Android11-6");
        capabilities.setCapability("platformVersion","11.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","package:com.bonpass.seller.v2.dev");
        capabilities.setCapability("appActivity",".com.bonpass.seller.screens.login.LoginActivity");
        capabilities.setCapability("app","/src/test/resources/apk/bonseller-2.0.27-dev-release.apk");

        driver = new AndroidDriver(new URL("http:localhost/wd/hub"), capabilities);}

    @AfterEach
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void firstTest()
    {
        System.out.println("First test run");
    }
}
