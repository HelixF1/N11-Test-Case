package com.n11.test.pages;

import com.n11.test.base.BasePage;
import org.openqa.selenium.By;

public class N11BasketPage extends BasePage {

    By buyButtonLocator = By.cssSelector(".orderSummaryBoxSticky #js-buyBtn");

    By prodDescription = By.className("prodDescription");

    By productQuantity = By.className("quantity");

    public N11BasketPage() {
        super("https://www.n11.com/sepetim");
    }

    public N11LoginPage clickBuyButton() {
        clickElement(buyButtonLocator);
        return new N11LoginPage();
    }

    public String getProductName() {
        return getElementText(prodDescription);
    }

    public String getProductQuantity() {
        return getElementValue(productQuantity);
    }
}
