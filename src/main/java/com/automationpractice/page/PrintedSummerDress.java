package com.automationpractice.page;

import com.codeborne.selenide.ElementsCollection;
import lombok.Data;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$;

@Data
public class PrintedSummerDress {
    @Getter
    private final String pageURL = "http://automationpractice.com/index.php?id_product=5&controller=product";
    // Выбирает все элементы товаров на странице. Всего 14, первые 7 товары
    private final ElementsCollection shopItems = $$("div.product-container");
}
