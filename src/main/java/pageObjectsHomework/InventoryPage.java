package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // add one product
    private final By addSauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By shoppingCartIcon = By.id("shopping_cart_container");

    public void addSauceLabsBikeLight() {
        WebElement element = driver.findElement(addSauceLabsBikeLight);
        element.click();
    }

    public void clickShoppingCartIcon() {
        WebElement element = driver.findElement(shoppingCartIcon);
        element.click();
    }
}
