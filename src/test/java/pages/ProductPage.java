package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver browser;
    private final By pageTitle = By.cssSelector("[data-test='title']");

    public ProductPage(WebDriver browser) {
        this.browser = browser;
    }

    public String getTitle() {
        return browser.findElement(pageTitle).getText();
    }

}
