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
//        switchTo().frame(element(By.className("fancybox-iframe")));

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
// Остаемся на сайте


//// листаем до
//        page.getPrntdSumDrContinue()
//                .scrollTo();
//// наводим курсор
//        actions()
//                .moveToElement(page.getPrntdSumDrContinue())
//                .perform();
//        switchTo().frame(element(By.className("layer_cart")));
//        switchTo().frame(element(By.className("clearfix")));
//        switchTo().frame(element(By.className("layer_cart_overlay")));
//        $(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")).click();
//        $(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[5]")).click();
        $(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")).click();
        actions()
                .moveToElement(page.getPrntdSumDrContinue3())
                .perform();

        page.getPrntdSumDrContinue3()
                .click();

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
