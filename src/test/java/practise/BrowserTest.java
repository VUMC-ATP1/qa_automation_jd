package practise;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_object.MainPage;

import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j
public class BrowserTest {

    ChromeDriver driver;
    MainPage mainPage;
    private final String GOOGLE_URL = "https://www.google.lv/";
    private final String LOCAL_FILE = "file://" + this.getClass().getResource("/elements.html").getPath();

    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Initialize ChromeDriver");
        driver = new ChromeDriver();

    }

    @Test(enabled = false)
    public void chromeDriverTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertEquals(driver.getCurrentUrl(), GOOGLE_URL);

    }

    @Test
    public void elementTest() {
        driver.get(LOCAL_FILE);
        driver.findElement(By.id("fNameID")).sendKeys("Jelena");
        driver.findElement(By.id("lNameID")).sendKeys("Dinere");
        driver.findElement(By.xpath("//textarea[@id='aboutMeID']")).sendKeys("Hello");
        driver.findElement(By.id("checkDataID")).click();


        WebElement nameField = driver.findElement(By.id("fNameID"));
        nameField.sendKeys("Jelena");

        WebElement lastNameField = driver.findElement(By.id("lNameID"));
        lastNameField.sendKeys("Dinere");

        Select universityDropDown = new Select(driver.findElement(By.name("universities")));
        universityDropDown.selectByValue("RSU");
        universityDropDown.selectByVisibleText("Rīgas Tehniskā universitāte");
        Assert.assertEquals(universityDropDown.getFirstSelectedOption().getText(), "Rīgas Tehniskā universitāte");

    }

    @Test
    public void pageObject() {
        mainPage = new MainPage(driver);
        driver.get(LOCAL_FILE);
        mainPage.setFirstNameField("Jelena");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Closing Chrome");
        driver.quit();
    }
}

