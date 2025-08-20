package kerem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11LoginPage extends BasePage {

    public N11LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(css = "div[data-errormessagefor='email']")
    private WebElement emailErrorMessage;

    @FindBy(css = "div[data-errormessagefor='password']")
    private WebElement passwordErrorMessage;

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public String getEmailErrorMessage() {
        return getElementText(emailErrorMessage);
    }

    public String getPasswordErrorMessage() {
        return getElementText(passwordErrorMessage);
    }
}
