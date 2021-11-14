package com.automationpractice.singleTests;

import com.automationpractice.page.Main;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AddToCartTest {

    @Before
    public void setBrowserConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

// Работает. Добавляем в корзину летнее платье и проверяем, что в корзине 1 товар
    @Test
    public void openPutDressToCartContinue() {
        Main page = new Main();
        open(page.getPageURL());
// Проверяем, что корзина пуста
        page.getCartEmpty()
                .shouldBe(Condition.enabled);
// Идем к летнему платью
        page.getPrintedSummerDress()
                .scrollTo();
// Наводим курсор
        actions()
                .moveToElement(page.getPrintedSummerDress())
                .perform();
// Нажатием кнопки добавляем в корзину
        page.getPrntdSumDrAddToCartSpawnButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
// Остаемся на сайте
        page.getСontinueShoppingButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
// Листаем до корзины
        actions()
                .moveToElement(page.getCartButton())
                .perform();
// Проверяем, что в корзине один товар
        page.getCartItemsQuantity()
                .shouldHave(text("1"));
        String itemsText = page.getCartItemsQuantity()
                .text();
        System.out.println("itemsText = " + itemsText);
        String currentUrl = getWebDriver().getCurrentUrl();
        System.out.println("currentUrl= " + currentUrl);
        sleep(2000);
    }

}
