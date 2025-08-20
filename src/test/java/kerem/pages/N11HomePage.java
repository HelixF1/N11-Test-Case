package kerem.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11HomePage extends BasePage {
    
    @FindBy(id = "myLocation-close-info")
    private WebElement locationCloseButton;
    
    @FindBy(id = "searchData")
    private WebElement searchBox;
    
    @FindBy(css = "div[class='resultText '] h1")
    private WebElement searchResultTitle;
    
    public N11HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void openHomePage() {
        driver.get("https://www.n11.com/");
    }
    
    public void closeLocationPopup() {
        clickElement(locationCloseButton);
    }
    
    public void searchProduct(String productName) {
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
    }
    
    public String getSearchResultTitle() {
        return getElementText(searchResultTitle);
    }
}
