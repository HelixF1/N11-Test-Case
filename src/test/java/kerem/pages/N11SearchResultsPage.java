package kerem.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class N11SearchResultsPage extends BasePage {
    
    @FindBy(css = "img.cardImage")
    private List<WebElement> productImages;
    
    public N11SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickThirdProduct() {
        waitForElementToBeVisible(productImages.get(2));
        WebElement thirdImage = productImages.get(2);
        
        WebElement productLink = thirdImage.findElement(By.xpath(".."));
        clickElement(productLink);
    }
}
