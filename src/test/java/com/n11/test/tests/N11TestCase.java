package com.n11.test.tests;

import com.n11.test.base.BaseTest;
import com.n11.test.pages.N11BasketPage;
import com.n11.test.pages.N11LoginPage;
import com.n11.test.pages.N11ProductPage;
import com.n11.test.pages.N11SearchResultsPage;
import org.testng.annotations.Test;

import static com.n11.test.helper.Consts.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class N11TestCase extends BaseTest {

    @Test
    public void shouldRedirectToLoginWhenClickBuyWithAGuestUserWithEnterSearch() {
        getHomePage().closeLocationPopup();
        getHomePage().clickAcceptCookies();
        N11SearchResultsPage searchResultsPage = getHomePage().searchProductWithEnter(KEYWORD);
        assertEquals(searchResultsPage.getSearchResultTitle(), KEYWORD);
        assertEquals(searchResultsPage.getBreadCrumbText(), KEYWORD);
        assertEquals(searchResultsPage.getSearchBoxValue(), KEYWORD);
        assertFalse(searchResultsPage.getProductContainers().isEmpty());

        String productName = searchResultsPage.getProductName(3);
        N11ProductPage productPage = searchResultsPage.clickProduct(3);
        assertEquals(productPage.getProductName(), productName);

        productPage.addToCart();
        assertEquals(productPage.getBasketCount(), "1");

        N11BasketPage basketPage = productPage.goToBasket();
        assertEquals(basketPage.getProductName(), productName);
        assertEquals(basketPage.getProductQuantity(), "1");

        N11LoginPage loginPage = basketPage.clickBuyButton();
        assertEquals(loginPage.getCurrentUrl(), "https://www.n11.com/giris-yap?gcht=1&donusurl=/sepetim");

        loginPage.clickLoginButton();
        assertEquals(loginPage.getEmailErrorMessage(), EMAIL_ERROR_MESSAGE);
        assertEquals(loginPage.getPasswordErrorMessage(), PASSWORD_ERROR_MESSAGE);
    }

    @Test
    public void shouldRedirectToLoginWhenClickBuyWithAGuestUserWithClickSearch() {
        getHomePage().closeLocationPopup();
        getHomePage().clickAcceptCookies();
        N11SearchResultsPage searchResultsPage = getHomePage().searchProductWithClick(KEYWORD);
        assertEquals(searchResultsPage.getSearchResultTitle(), KEYWORD);
        assertEquals(searchResultsPage.getBreadCrumbText(), KEYWORD);
        assertEquals(searchResultsPage.getSearchBoxValue(), KEYWORD);
        assertFalse(searchResultsPage.getProductContainers().isEmpty());

        String productName = searchResultsPage.getProductName(3);
        N11ProductPage productPage = searchResultsPage.clickProduct(3);
        assertEquals(productPage.getProductName(), productName);

        productPage.addToCart();
        assertEquals(productPage.getBasketCount(), "1");

        N11BasketPage basketPage = productPage.goToBasket();
        assertEquals(basketPage.getProductName(), productName);
        assertEquals(basketPage.getProductQuantity(), "1");

        N11LoginPage loginPage = basketPage.clickBuyButton();
        assertEquals(loginPage.getCurrentUrl(), "https://www.n11.com/giris-yap?gcht=1&donusurl=/sepetim");

        loginPage.clickLoginButton();
        assertEquals(loginPage.getEmailErrorMessage(), EMAIL_ERROR_MESSAGE);
        assertEquals(loginPage.getPasswordErrorMessage(), PASSWORD_ERROR_MESSAGE);
    }
}
