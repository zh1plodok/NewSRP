package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductPage;

import java.time.Duration;

public class BaseTest {
    public WebDriver browser;
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("headless");
        options.addArguments("guest");
        browser = new ChromeDriver(options);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(browser);
        productPage = new ProductPage(browser);
    }

      @AfterMethod
      public void close() {
       browser.quit();
    }
}