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


public class AddByGoingToDressPageTest {

    @Before
    public void setBrowserConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

// не работает
// Добавляю нужное количество и размер через переход на страницу товара
    @Test
    public void openPutDressToCartAnyItem() {
        Main mainPage = new Main();
        open(mainPage.getPageURL());
// проверяем что корзина пуста
        mainPage.getCartEmpty()
                .shouldBe(Condition.enabled);
// идем на страницу с платьями
        mainPage.getDressesButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
// создаем экземпляр класса для страницы с платьями
        Dresses dressPage = new Dresses();
// выбираем платье Printed Summer Dress
        SelenideElement myItem = dressPage.getShopItemsImg()
                .filterBy((Condition.attribute(
                        "title",
                        "Printed Summer Dress"))).get(0);
// листаем до элемента
        dressPage.getPrintedSummerDressMore()
                .scrollTo()
                .click();

// наводим курсор на элемент
//        actions()
//                .moveToElement(myItem)
//                .perform();
// кликаем найденный элемент
//        myItem
//                .shouldBe(Condition.enabled, Condition.visible)
//                .click();
//        sleep(4000);
//        page.getСontinueShoppingButton()
//                .shouldBe(Condition.enabled, Condition.visible)
//                .click();
//        actions()
//                .moveToElement(page.getCartButton())
//                .perform();
//        page.getCartItemsQuantity()
//                .shouldHave(Condition.text("1"));
//        String itemsText1 = page.getCartItemsQuantity()
//                .text();
//        System.out.println("itemsText1 = " + itemsText1);
//        page.getCartItems()
//                .filterBy((Condition.attribute("Title","Printed Summer Dress")))
//                .first()
//                .click();
//        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
//        System.out.println("currentUrl= " + currentUrl);
//        sleep(3000);
    }
}
