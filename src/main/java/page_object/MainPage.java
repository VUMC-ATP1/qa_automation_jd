package page_object;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstNameField = By.id("fNameID");
    private final By clickOnMeButton = By.xpath("//button[@id=checkDataID]");
    private final By studentCheckBox = By.xpath("//input[@id=studentID and @type=checkbox]");
    private final By universities = By.name("universities");
    private final By javaRadioButton = By.id("javaID");

    public WebElement getFirstNameField() {

        return driver.findElement(firstNameField);
    }

    public void setFirstNameField(String value) {
        getFirstNameField().sendKeys(value);
    }

    public void clickOnMe() {
        driver.findElement(clickOnMeButton).click();
    }

    public void selectStudentCheckBox() {
        WebElement element = driver.findElement(studentCheckBox);
        element.click();
        Assert.assertTrue(element.isDisplayed());//neiet assertTrue
    }


    public Select getUniversities() {
        return new Select(driver.findElement(universities));
    }

    public List<WebElement> getUniversitiesList() {
        return getUniversities().getOptions();
    }
}
