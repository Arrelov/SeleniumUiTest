package com.automationpractice.steps.desktop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.automationpractice.page.Cart;
import com.automationpractice.page.Main;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class DesktopSteps {

    @BeforeAll
    public static void setBrowserConfig() {
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        Configuration.timeout = 3000;
    }

    @Given("Set browser {string}")
    public void setBrowser(String browser){
        Configuration.browser = browser;
        System.out.println("browser = " + browser);
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

    @When("I click add to cart button for the dress")
    public void i_click_add_to_cart_button_for_the_dress() {
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
        Main page = new Main();
        page.getCartDeleteElement()
                .shouldBe(Condition.enabled, Condition.visible)
                .click();
    }

    @AfterAll
    public static void closeAll() {
        Selenide.closeWebDriver();
    }
}
