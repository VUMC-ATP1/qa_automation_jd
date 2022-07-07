package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By userNameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By clickOnLoginButton = By.id("login-button");

    public WebElement getUserNameField() {
        return driver.findElement(userNameField);
    }

    public void setUserNameField(String value) {
        driver.findElement(userNameField).sendKeys(value);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public void setPasswordField(String value) {
        driver.findElement(passwordField).sendKeys(value);
    }

    public void clickOnLoginButton() {
        WebElement element = driver.findElement(clickOnLoginButton);
        element.click();
    }
}
