package com.automationpractice.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Data
public class Dresses {
    @Getter
    private final String pageURL = "http://automationpractice.com/index.php?id_category=8&controller=category";
// Выбирает все элементы товаров на странице. Всего 14, первые 7 товары
    private final ElementsCollection shopItems = $$("div.product-container");
// выбирает все кнопки Add to Cart на странице. На главной их 7 реальные из 14 видимые
    private final ElementsCollection addToCartButtons = $$("a[title='Add to cart']");
// находит 5 элементов. Можно искать по title, но они повторяются
    private final ElementsCollection shopItemsImg = $$(By
            .className("product_img_link"));

// локаторы для первого в списке (светлого) платья с title Printed Summer Dress
// Кнопка More для перехода на страницу товара
    private final SelenideElement printedSummerDressMore = $(By
        .xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[2]/a[2]/span"));
}
