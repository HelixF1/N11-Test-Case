package com.n11.test.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.n11.test.base.BaseTest.getDriver;


public abstract class BasePage {

    public final String PAGE_URL;

    protected WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    public By searchBox = By.id("searchData");

    By basketIcon = By.className("basketTotalNum");

    public BasePage(String pageURL) {
        PAGE_URL = pageURL;
    }

    protected WebElement waitForElementToBeVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void clickElement(By byLocator) {
        getWait().until(ExpectedConditions.elementToBeClickable(byLocator))
                .click();
    }

    protected void clickElement(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    protected String getElementText(By byLocator) {
        return waitForElementToBeVisible(byLocator)
                .getText();
    }

    protected String getElementValue(By byLocator) {
        return waitForElementToBeVisible(byLocator)
                .getAttribute("value");
    }

    public String getBasketCount() {
        return getElementText(basketIcon);
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
}
