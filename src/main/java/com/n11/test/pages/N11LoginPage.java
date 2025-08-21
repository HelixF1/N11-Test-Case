package com.n11.test.pages;

import com.n11.test.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.n11.test.base.BaseTest.getDriver;


public class N11LoginPage extends BasePage {

    public N11LoginPage() {
        super("https://www.n11.com/giris-yap?gcht=1&donusurl=/sepetim");
    }

    By loginButtonLocator = By.id("loginButton");

    By emailErrorMessageLocator = By.cssSelector("div[data-errormessagefor='email']");

    By passwordErrorMessageLocator = By.cssSelector("div[data-errormessagefor='password']");

    public void clickLoginButton() {
        clickElement(loginButtonLocator);
    }

    public String getEmailErrorMessage() {
        return getElementText(emailErrorMessageLocator);
    }

    public String getPasswordErrorMessage() {
        return getElementText(passwordErrorMessageLocator);
    }

    public String getCurrentUrl() {
        getWait().until(ExpectedConditions.urlContains("giris-yap"));
        return getDriver().getCurrentUrl();
    }
}
