package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver browser;
    private final By userField = By.cssSelector("[id='user-name']");
    private final By passwordField = By.xpath("//*[@placeholder='Password']");
    private final By sumbitButton = By.cssSelector("[data-test='login-button']");
    private final By errorMessege = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public void open() {
        browser.get("https://www.saucedemo.com/");
    }

    public void login(String login, String password) {
        browser.findElement(userField).sendKeys(login);
        browser.findElement(passwordField).sendKeys(password);
        browser.findElement(sumbitButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return browser.findElement(errorMessege).isDisplayed();
    }

    public String getErrorMessage() {
        return browser.findElement(errorMessege).getText();
    }
}