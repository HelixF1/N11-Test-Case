package kerem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11BasketPage extends BasePage {
    
    @FindBy(css = "#js-buyBtn")
    private WebElement buyButton;
    
    public N11BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void clickBuyButton() {
        clickElement(buyButton);
    }
}
