package com.n11.test.pages;

import com.n11.test.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.n11.test.base.BaseTest.getDriver;


public class N11SearchResultsPage extends BasePage {

    public N11SearchResultsPage() {
        super("https://www.n11.com/arama?q=ayfon");
    }

    By productContainer = By.className("pro");

    By searchResultTitle = By.cssSelector(".resultText > h1");

    By secondBreadCrumb = By.cssSelector("#breadCrumb li:nth-child(2)");

    public N11ProductPage clickProduct(int productOrder) {
        List<WebElement> productImagesList = getProductContainers();
        WebElement product = productImagesList.get(productOrder - 1);
        clickElement(product);

        return new N11ProductPage();
    }

    public String getProductName(int order) {
        List<WebElement> products = getProductContainers();
        WebElement product = products.get(order - 1);
        return product.findElement(By.className("productName")).getText();
    }

    public List<WebElement> getProductContainers() {
        return getDriver().findElements(productContainer);
    }

    public String getSearchResultTitle() {
        return getElementText(searchResultTitle).toLowerCase();
    }

    public String getBreadCrumbText() {
        return getElementText(secondBreadCrumb);
    }

    public String getSearchBoxValue() {
        return getElementValue(searchBox);
    }
}
