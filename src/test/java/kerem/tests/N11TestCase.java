package kerem.tests;

import kerem.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class N11TestCase {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private N11HomePage homePage;
    private N11SearchResultsPage searchResultsPage;
    private N11ProductPage productPage;
    private N11BasketPage basketPage;
    private N11LoginPage loginPage;
    
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homePage = new N11HomePage(driver);
        searchResultsPage = new N11SearchResultsPage(driver);
        productPage = new N11ProductPage(driver);
        basketPage = new N11BasketPage(driver);
        loginPage = new N11LoginPage(driver);
    }
    
    @Test
    public void n11TestScenario() {
        homePage.openHomePage();
        homePage.closeLocationPopup();

        homePage.searchProduct("ayfon");
        Assert.assertTrue(homePage.getSearchResultTitle().equalsIgnoreCase("ayfon"));

        searchResultsPage.clickThirdProduct();

        productPage.addToCart();
        productPage.goToBasket();

        basketPage.clickBuyButton();

        loginPage.clickLoginButton();
        
        String emailError = loginPage.getEmailErrorMessage();
        String passwordError = loginPage.getPasswordErrorMessage();
        
        Assert.assertEquals(emailError, "Geçerli bir e-posta adresi girmelisin.");
        Assert.assertEquals(passwordError, "Şifreni girebilir misin?");
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
