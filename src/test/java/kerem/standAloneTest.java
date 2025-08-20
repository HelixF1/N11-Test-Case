package kerem;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class standAloneTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.n11.com/");

        driver.findElement(By.id("myLocation-close-info")).click();

        WebElement searchItem = driver.findElement(By.id("searchData"));
        searchItem.sendKeys("ayfon");
        searchItem.sendKeys(Keys.ENTER);

        WebElement searchValidate = driver.findElement(By.cssSelector("div[class='resultText '] h1"));
        Assert.assertTrue(searchValidate.getText().equalsIgnoreCase("ayfon"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector("img.cardImage"), 2));

        List<WebElement> images = driver.findElements(By.cssSelector("img.cardImage"));
        WebElement thirdImage = images.get(2);

        WebElement productLink = thirdImage.findElement(By.xpath(".."));
        wait.until(ExpectedConditions.elementToBeClickable(productLink));
        productLink.click();

        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Sepete Ekle') or contains(text(), 'SEPETE EKLE')]")));
        addToCartBtn.click();


        WebElement basketPopup = driver.findElement(By.cssSelector(".btnGoBasket"));
        wait.until(ExpectedConditions.elementToBeClickable(basketPopup));

        basketPopup.click();

        WebElement buyButton = driver.findElement(By.cssSelector("#js-buyBtn"));
        buyButton.click();

        driver.findElement(By.id("loginButton")).click();

        WebElement emailError = driver.findElement(By.cssSelector("div[data-errormessagefor='email']"));
        WebElement passwordError = driver.findElement(By.cssSelector("div[data-errormessagefor='password']"));

        wait.until(ExpectedConditions.visibilityOf(emailError));
        wait.until(ExpectedConditions.visibilityOf(passwordError));

        Assert.assertEquals(emailError.getText(), "Geçerli bir e-posta adresi girmelisin.");
        Assert.assertEquals(passwordError.getText(), "Şifreni girebilir misin?");
        
        System.out.println("Email hatası: " + emailError.getText());
        System.out.println("Password hatası: " + passwordError.getText());

        driver.quit();
    }
}
