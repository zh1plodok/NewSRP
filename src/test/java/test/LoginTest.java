package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void checlogin() {
        browser.findElement(By.cssSelector("[id='user-name']")).sendKeys("standard_user");
        // browser.findElement(By.cssSelector("[id='user-name']")).sendKeys(Keys.CONTROL + "A");
        // browser.findElement(By.cssSelector("[id='user-name']")).sendKeys(Keys.BACK_SPACE);
        browser.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("[data-test='login-button']")).click();
        String title = browser.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(title, "Products");
    }

    @Test
    public void checIncoretlogin() {
        browser.findElement(By.cssSelector("[id='user-name']")).sendKeys("locked_out_user");
        browser.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("[data-test='login-button']")).click();
        boolean errorMessage = browser.findElement(By.xpath("//*[@data-test='error']")).isDisplayed();
        assertTrue(errorMessage, "The error message fails to appear");
    }

    @Test
    public void errorTextValid() {
        browser.findElement(By.cssSelector("[id='user-name']")).sendKeys("");
        browser.findElement(By.cssSelector("[id='password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("[data-test='login-button']")).click();
        String title = browser.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(title, "Epic sadface: Username is required");

    }
}
