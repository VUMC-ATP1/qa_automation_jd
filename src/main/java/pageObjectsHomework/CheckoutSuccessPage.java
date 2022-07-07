package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    private WebElement element;
    private WebDriver driver;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By backHomeButton = By.id("back-to-products");
    private final By thankYouHeader = By.xpath("//*[@id='checkout_complete_container']/h2");

    public void clickBackHomeButton() {
        element = driver.findElement(backHomeButton);
        element.click();
    }

    public WebElement getThankYouHeader() {
        return driver.findElement(thankYouHeader);
    }
}
