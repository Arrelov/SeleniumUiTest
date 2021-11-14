package com.automationpractice.page;

import lombok.Data;
import lombok.Getter;

@Data
public class Cart {
    @Getter
    private final String pageURL = "http://automationpractice.com/index.php?controller=order";
}
