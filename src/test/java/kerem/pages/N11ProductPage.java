package kerem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11ProductPage extends BasePage {

    public N11ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Sepete Ekle') or contains(text(), 'SEPETE EKLE')]")
    private WebElement addToCartButton;

    @FindBy(css = ".btnGoBasket")
    private WebElement goToBasketButton;

    public void addToCart() {
        clickElement(addToCartButton);
    }
    
    public void goToBasket() {
        clickElement(goToBasketButton);
    }
}
