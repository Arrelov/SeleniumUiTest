package com.automationpractice.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Data
public class Main {
    @Getter
    private final String pageURL = "http://automationpractice.com/index.php";

// Кнопки для перехода на другие страницы
// Кнопка перехода на страницу Cart
    private final SelenideElement cartButton = $(By
            .xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
//  Кнопка перехода на вкладку Dresses
    private final SelenideElement dressesButton = $(By
            .xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));

// Локаторы товаров
// локаторы для первого в списке (светлого) платья с title Printed Summer Dress
    private final SelenideElement printedSummerDress = $(By
            .xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[1]/div/a[1]/img"));
    private final SelenideElement prntdSumDrAddToCartSpawnButton = $(By
            .xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/div[2]/a[1]/span"));
    private final SelenideElement prntdSumDrQuickView = $(By
            .xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[1]/div/div[1]/a"));
    private final SelenideElement prntdSumDrQuickView2 = $(By
            .xpath("(//a[@class='quick-view'])[5]"));
// fancybox-iframe возможно работает для всех товаров
    private final SelenideElement prntdSumDrToFancy = $(By.className("fancybox-iframe"));
    private final SelenideElement prntdSumDrQiantity = $(By.id("quantity_wanted"));
    private final SelenideElement prntdSumDrSize = $(By.id("group_1"));
    private final SelenideElement prntdSumDrAddToCartFancybox = $(By.id("add_to_cart"));
    private final SelenideElement prntdSumDrContinue = $(byText("Continue shopping"));
    private final SelenideElement prntdSumDrContinue2 = $(By
            .xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span"));
    private final SelenideElement prntdSumDrContinue3 = $(By
            .xpath("//*[contains(text(),'Continue shopping')]"));
    private final SelenideElement prntdSumDrToCart = $(byText("Proceed to checkout"));


// поиск товара по тексту
    private final SelenideElement shopItemsByText = $(byText("Faded Short Sleeve T-shirts"));

//  Групповые локаторы товаров
//  находит 14 элементов. Первые 7 это товары. Не получается искать по ним ((
    private final ElementsCollection shopItems = $$("div.product-container");
//  находит 14 элементов. Первые 7 это товары, можно искать по title, но они повторяются
    private final ElementsCollection shopItemsImg = $$(By
            .className("product_img_link"));
//  находит 14 элементов. Первые 7 это товары
    private final ElementsCollection shopItemsQuickView = $$(("a.quick-view"));


// кнопки выбора после добавления в корзину одинаковые для всех товаров
// переход к корзине
    private final SelenideElement proceedToCheckoutButton = $(By
            .xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
// либо остаться на главной
    private final SelenideElement сontinueShoppingButton = $(By
            .xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));

//выбирает все кнопки Add to Cart на странице. На главной их 7 реальные из 14 видимые
    private final ElementsCollection addToCartButtons = $$("a[title='Add to cart']");


//  Кнопка Корзина на главной странице
//  счетчик товаров в корзине
    private final SelenideElement cartItemsQuantity = $(By
            .className("ajax_cart_quantity"));
//  если корзина пуста счетчик находится так
    private final SelenideElement cartEmpty = $(By
            .className("ajax_cart_quantity"));
//  элементы товаров, добавленных в корзину
    private final ElementsCollection cartItems = $$(By
            .className("cart-images"));
// крестик удаления добавленного элемента
    private final SelenideElement cartDeleteElement = $(By
            .className("ajax_cart_block_remove_link"));
}
