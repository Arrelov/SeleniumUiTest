package com.automationpractice.singleTests;

import com.automationpractice.page.Main;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SmokeCartTest {

    @Before
    public void setBrowserConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    public void openPutDressToCartContinue() {
        Main page = new Main();
        open(page.getPageURL());
// Проверяем, что корзина пуста
        page.getCartEmpty()
                .shouldBe(Condition.enabled);
        sleep(2000);
    }

}
