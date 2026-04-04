package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver browser;
    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("headless");
        options.addArguments("guest");
        browser = new ChromeDriver(options);
        //browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get("https://www.saucedemo.com/");
    }
    @AfterMethod
    public void close() {
        browser.quit();
    }
}
