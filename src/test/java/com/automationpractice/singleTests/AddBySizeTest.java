package com.automationpractice.singleTests;

import com.automationpractice.page.Dresses;
import com.automationpractice.page.Main;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class AddBySizeTest {

    @Before
    public void setBrowserConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

// здесь добавляю в корзину нужное количество и выбираю размер
// После добавления в корзину ничего не могу сделать. Перепробовал всё что мог
    @Test
    public void openPutDressToCartWithSize() {
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
// переходим к быстрому просмотру
        page.getPrntdSumDrQuickView2()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
//switch to iFrame
        switchTo().frame(page.getPrntdSumDrToFancy());
//fill quantity field
        page.getPrntdSumDrQiantity()
                .setValue("3");
//select size
        page.getPrntdSumDrSize()
                .selectOption("L");
//click on Add product
        page.getPrntdSumDrAddToCartFancybox()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
// Остаемся на сайте. Нет, не получается остаться. Всё, что я смог сделать тут, это
        actions()
                .moveToElement($$x("div.clearfix").get(3))
                .perform();
        switchTo().frame($$x("div.clearfix").get(3));
//        $(By.className("clearfix")).click(); // переход на страницу товара
// ну ладно. корзина на всех страницах выглядит одинаково, так что

// Листаем до корзины
        actions()
                .moveToElement(page.getCartButton())
                .perform();
// Проверяем, что в корзине нужное количество товаров
        page.getCartItemsQuantity()
                .shouldHave(text("3"));
        String itemsText = page.getCartItemsQuantity()
                .text();
        System.out.println("itemsText = " + itemsText);
        String currentUrl = getWebDriver().getCurrentUrl();
        System.out.println("currentUrl= " + currentUrl);
        sleep(3000);
    }
}
