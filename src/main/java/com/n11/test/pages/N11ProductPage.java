package com.n11.test.pages;

import com.n11.test.base.BasePage;
import org.openqa.selenium.By;

public class N11ProductPage extends BasePage {

    public N11ProductPage() {
        super("https://www.n11.com/urun/");
    }

    By addToCartButton = By.cssSelector(".product-add-cart > .addBasketUnify");

    By goToBasketButton = By.className("iconsBasketWhite");

    By productName = By.className("proName");

    public void addToCart() {
        clickElement(addToCartButton);
    }

    public N11BasketPage goToBasket() {
        clickElement(goToBasketButton);
        return new N11BasketPage();
    }

    public String getProductName() {
        return getElementText(productName);
    }
}
