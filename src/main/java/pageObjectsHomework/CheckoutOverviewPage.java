package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    private WebElement element;
    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By itemName = By.id("item_0_title_link");
    private final By clickFinishButton = By.id("finish");

    public WebElement getItemName() {
        return driver.findElement(itemName);
    }

    public void clickFinishButton() {
        element = driver.findElement(clickFinishButton);
        element.click();
    }

}
