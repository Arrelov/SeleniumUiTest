package com.automationpractice;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import com.automationpractice.page.Main;
import com.automationpractice.page.Dresses;
import org.openqa.selenium.WebDriver;

import java.awt.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class RawManualTests {

    @Before
    public void setBrowserConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

    }

    @Test // smoke test
    public void openPutDressToCart() {
        Configuration.startMaximized = false;
        Configuration.browser = "opera";
        Configuration.browserSize= "500x900";
        Configuration.browserPosition= "1x1";

        Main page = new Main();
        open(page.getPageURL());
        page.getPrintedSummerDress()
                        .scrollTo();
        actions()
                .moveToElement(page.getPrintedSummerDress())
                .perform();
        page.getPrntdSumDrAddToCartSpawnButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
        page.getСontinueShoppingButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
        page.getCartButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
        String currentUrl = getWebDriver().getCurrentUrl();
        System.out.println("currentUrl= " + currentUrl);
    }


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

//        page.getCartItems()
////                .filterBy((Condition.attribute("title","Printed Summer Dress")))
//                .get(1)
//                .click();
        String currentUrl = getWebDriver().getCurrentUrl();
        System.out.println("currentUrl= " + currentUrl);
        sleep(3000);
    }

    @Test       // Падает после добавления в корзину. Перепробовал всё что мог
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


//// Остаемся на сайте

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
// Проверяем, что в корзине один товар
        page.getCartItemsQuantity()
                .shouldHave(text("3"));
        String itemsText = page.getCartItemsQuantity()
                .text();
        System.out.println("itemsText = " + itemsText);
//        page.getCartItems()
////                .filterBy((Condition.attribute("title","Printed Summer Dress")))
//                .get(1)
//                .click();
        String currentUrl = getWebDriver().getCurrentUrl();
        System.out.println("currentUrl= " + currentUrl);
        sleep(3000);
    }

    @Test
    public void openPutDressToCartManyItems() {
        Main page = new Main();
        open(page.getPageURL());
//  Проверяем, что корзина пуста
        page.getCartEmpty()
                .shouldBe(Condition.enabled);
        SelenideElement myItem = page.getShopItemsQuickView()
//                .filterBy((Condition.attribute(
//                        "title",
//                        "Printed Summer Dress"))).get(0)
//                .findBy((Condition.attribute(
//                        "title",
//                        "Printed Summer Dress")))
                .get(3)
                ;
        myItem
                .scrollTo();
        actions()
                .moveToElement(myItem)
                .perform();
        page.getPrntdSumDrAddToCartSpawnButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
        page.getСontinueShoppingButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
        actions()
                .moveToElement(page.getCartButton())
                .perform();
        page.getCartItemsQuantity()
                .shouldHave(text("1"));
        String itemsText1 = page.getCartItemsQuantity()
                .text();
        System.out.println("itemsText1 = " + itemsText1);
        page.getCartItems()
                .filterBy((Condition.attribute("Title","Printed Summer Dress")))
                .first()
                .click();
        String currentUrl = getWebDriver().getCurrentUrl();
        System.out.println("currentUrl= " + currentUrl);
        sleep(3000);
    }

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
                        "Printed Summer Dress"))).get(0)
//                .findBy((Condition.attribute(
//                        "title",
//                        "Printed Summer Dress")))
//                .get(3)
                ;
// листаем до элемента
        myItem
                .scrollTo();
// наводим курсор на элемент
        actions()
                .moveToElement(myItem)
                .perform();
// кликаем найденный элемент
        myItem
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
        sleep(4000);
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

    @Test
    public void addProductToCart(){
        open("http://automationpractice.com");
//        SelenideElement product = element(By.linkText("Faded Short Sleeve T-shirts"));
        SelenideElement product = element(byText("Faded Short Sleeve T-shirts"));
        //scroll to the first product
        product.scrollTo();
        //move mouse to the first product
        actions().moveToElement(product).perform();
        //click on Quick view element on the product
        element(By.xpath("(//a[@class='quick-view'])[1]")).click();
        //switch to iFrame
        switchTo().frame(element(By.className("fancybox-iframe")));
        //fill quantity field
        element(By.id("quantity_wanted")).setValue("2");
        //select size
        element(By.id("group_1")).selectOption("M");
        //click on Add product
        element(By.id("add_to_cart")).click();
        //click Proceed to checkout
        element(byText("Proceed to checkout")).click();
        //check if 2 products in cart
        element(By.id("summary_products_quantity")).shouldHave(text("2 Products"));
    }

    @Test
    public void setSearchText() {
        Main page = new Main();
        page.getCartButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();

    }

}
