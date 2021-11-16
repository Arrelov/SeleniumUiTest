package com.automationpractice.steps.mobile;

import com.automationpractice.page.Cart;
import com.automationpractice.page.Main;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class MobileSteps {

    @BeforeAll
    public static void setBrowserConfig() {
        Configuration.browser = "chrome";
        Configuration.timeout = 3000;
    }

    @Given("Set browser {string}")
    public void setBrowser(String browser){
        Configuration.browser = browser;
        System.out.println("browser = " + browser);
    }

    @Given("Set browser window size {int} x {int}")
    public void setBrowserSize(int width, int length ){
        Configuration.browserSize = width + "x" + length;
        Configuration.browserPosition= "1x1";
        System.out.println("browserSize = " + width + "x" + length);
    }

    @Given("I open main page")
    public void openWikiPage() {
        Main page = new Main();
        open(page.getPageURL());
    }

    @When("I click to cart button")
    public void i_click_to_cart_button() {
        Main page = new Main();
        page.getCartButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
    }

    @Then("I see cart page")
    public void i_see_cart_page() {
        Cart page = new Cart();
        String targetUrl =  page.getPageURL();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        System.out.println("currentUrl= " + currentUrl);
        System.out.println("targetUrl = " + targetUrl);
        webdriver().shouldHave(urlContaining(targetUrl));
    }

    @Given("Cart is empty")
    public void cart_is_empty() {
        Main page = new Main();
        open(page.getPageURL());
        page.getCartEmpty()
                .shouldBe(Condition.enabled);
    }

    @When("I click add to cart button for the Printed Summer Dress")
    public void i_click_add_to_cart_button_for_the_summer_dress() {
        Main page = new Main();
// Листаем страницу до платья
        page.getPrintedSummerDress()
                .scrollTo();
// Наводим курсор на платье
        actions()
                .moveToElement(page.getPrintedSummerDress())
                .perform();
// Нажимаем кнопку добавления в корзину этого платья
        page.getPrntdSumDrAddToCartSpawnButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
// Нажимаем кнопку чтобы остаться на странице
        page.getСontinueShoppingButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
    }

    @When("I click add to cart button for the Printed Chiffon Dress")
    public void i_click_add_to_cart_button_for_the_chiffon_dress() {
        Main page = new Main();
// Листаем страницу до платья
        page.getPrintedChiffonDress()
                .scrollTo();
// Наводим курсор на платье
        actions()
                .moveToElement(page.getPrintedChiffonDress())
                .perform();
// Нажимаем кнопку добавления в корзину этого платья
        page.getPrntdChiffDrAddToCartButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
// Нажимаем кнопку чтобы остаться на странице
        page.getСontinueShoppingButton()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
    }

    @Then("I see {int} item\\(s) in cart")
    public void i_see_one_item_in_cart(int number) {
        Main page = new Main();
// Перемещаемся до кнопки корзины
        actions()
                .moveToElement(page.getCartButton())
                .perform();
// Проверяем, что в корзине один элемент
        page.getCartItemsQuantity()
                .shouldHave(Condition.text(String.valueOf(number)));
        String itemsText = page.getCartItemsQuantity()
                .text();
        System.out.println("itemsText = " + itemsText);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        System.out.println("currentUrl= " + currentUrl);
    }

    @When("I click button to remove dress from cart")
    public void i_click_button_to_remove_dress_from_cart() {
// Перемещаемся до кнопки корзины
        Main page = new Main();
        actions()
                .moveToElement(page.getCartButton())
                .perform();
// Удаляем содержимое из корзины
        page.getCartDeleteElement()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
    }

    @After
    public static void closeAll() {
        Selenide.closeWebDriver();
    }
}
