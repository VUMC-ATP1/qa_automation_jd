package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private WebDriver driver;
    private WebElement element;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstNameField = By.xpath("//input[@id='first-name']");
    private final By lastNameField = By.xpath("//input[@id='last-name']");
    private final By zipOrPostalCodeField = By.xpath("//input[@id='postal-code']");
    private final By continueButton = By.id("continue");

    private final By errorMessage = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3");
    public WebElement getFirstNameField() {
        return driver.findElement(firstNameField);
    }

    public void setFirstNameField(String value) {
        driver.findElement(firstNameField).sendKeys(value);
    }

    public WebElement getLastNameField() {
        return driver.findElement(lastNameField);
    }

    public void setLastNameField(String value) {
        driver.findElement(lastNameField).sendKeys(value);
    }

    public WebElement getZipOrPostCode() {
        return driver.findElement(zipOrPostalCodeField);
    }

    public void setZipOrPostCodeField(String value) {
        driver.findElement(zipOrPostalCodeField).sendKeys(value);
    }

    public void clickOnContinueButton() {
        element = driver.findElement(continueButton);
        element.click();
    }

    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }
}
