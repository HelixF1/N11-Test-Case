package com.n11.test.base;

import com.n11.test.pages.N11HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static final ThreadLocal<N11HomePage> homePage = new ThreadLocal<>();

    protected N11HomePage getHomePage() {
        return homePage.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver.set(new ChromeDriver());
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        homePage.set(new N11HomePage());
        getDriver().get(homePage.get().PAGE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            getDriver().quit();
        } finally {
            driver.remove();
            homePage.remove();
        }
    }
}
