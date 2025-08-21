package com.n11.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.n11.test.tests.BaseTest.getDriver;
import static java.sql.DriverManager.getDriver;
import static org.openqa.selenium.Keys.ENTER;

public class N11HomePage extends BasePage {

    public N11HomePage() {
        super("https://www.n11.com/");
    }

    By locationCloseButton = By.id("myLocation-close-info");

    By iconSearchButton = By.className("iconsSearch");

    public void closeLocationPopup() {
        clickElement(locationCloseButton);
    }

    public void clickAcceptCookies() {
        WebElement shadowHost = getWait().until(ExpectedConditions.presenceOfElementLocated(By.tagName("efilli-layout-dynamic")));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement acceptButton = shadowRoot.findElement(By.cssSelector("[data-name='Accept Button']"));
        acceptButton.click();
    }

    public N11SearchResultsPage searchProductWithEnter(String productName) {
        getDriver().findElement(searchBox).sendKeys(productName + ENTER);
        return new N11SearchResultsPage();
    }

    public N11SearchResultsPage searchProductWithClick(String productName) {
        getDriver().findElement(searchBox).sendKeys(productName);
        clickElement(iconSearchButton);
        return new N11SearchResultsPage();
    }
}
