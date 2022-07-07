package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;
    private WebElement element;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkoutButton = By.id("checkout");
    private final By productName = By.id("item_0_title_link");

    public void clickCheckOutButton() {
        element = driver.findElement(checkoutButton);
        element.click();
    }

    public WebElement getProductName() {
        return driver.findElement(productName);
    }
}
