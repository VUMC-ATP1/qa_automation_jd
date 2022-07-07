package seleniumHomework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

@Log4j
public class sauceDemoTests {
    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CheckoutPage checkoutPage;
    CartPage cartPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutSuccessPage checkoutComplete;
    private final String SAUCE_URL = "https://www.saucedemo.com/";
    private final String SAUCE_URL_INVENTORY = "https://www.saucedemo.com/inventory.html";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutComplete = new CheckoutSuccessPage(driver);
    }

    /*
    1. Scenārijs

1. Navigēt uz saiti https://www.saucedemo.com/
2. Ielogoties ar pareizu lietotāja vārdu/paroli
3. Pārbaudīt, ka lietotājs ir ielogojies
4. Ievietot Grozā 1 produktu
5. Doties uz grozu
6. Pārbaudīt, kā šī prece ir grozā
7. Doties uz Checkout
8. Ievadīt vārdu/uzvārdu/pasta indeksu
9. Doties uz Checkout overview lapu, pārbaudīt datus
10. Doties uz finish lapu un pārbaudīt vai viss bija veiksmīgi
11. Doties atpakaļ uz pirmo lapu ar pogu 'Back Home'

     */
    @Test
    public void testOne() {
        driver.get(SAUCE_URL);
        //log in
        loginPage.getUserNameField().sendKeys("standard_user");
        loginPage.getPasswordField().sendKeys("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), SAUCE_URL_INVENTORY);
        //add one product
        inventoryPage.addSauceLabsBikeLight();
        inventoryPage.clickShoppingCartIcon();
        Assert.assertEquals(cartPage.getProductName().getText(), "Sauce Labs Bike Light");
        //checkout section
        checkoutPage.getFirstNameField().sendKeys("Jelena");
        checkoutPage.getLastNameField().sendKeys("Dinere");
        checkoutPage.getZipOrPostCode().sendKeys("2201");
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutOverviewPage.getItemName().getText(), "Sauce Labs Bike Light");
        checkoutOverviewPage.clickFinishButton();

        //Check whether the user has succeeded
        Assert.assertEquals(checkoutComplete.getThankYouHeader().getText(), "THANK YOU FOR YOUR ORDER");
        checkoutComplete.clickBackHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(), SAUCE_URL_INVENTORY);
    }

    /*
    1. Navigēt uz saiti Error! Hyperlink reference not valid.
2. Ielogoties ar pareizu lietotāja vārdu/paroli
3. Doties uz grozu
4. Doties uz Checkout
5. Pārbaudīt, ka FirstName/LastName/Zip code ir obligāts
6. Pārbaudīt, ka forma parāda pareizu kļūdas paziņojumu pie katra neievadītā lauka

     */
    @Test
    public void testTwo() {
        driver.get(SAUCE_URL);
        //log in
        loginPage.getUserNameField().sendKeys("standard_user");
        loginPage.getPasswordField().sendKeys("secret_sauce");
        loginPage.clickOnLoginButton();
        //go to the shopping cart
        inventoryPage.clickShoppingCartIcon();
        //go to the checkout
        cartPage.clickCheckOutButton();
        // //check if displays the correct error message for each field
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: First Name is required");
        checkoutPage.getFirstNameField().sendKeys("Jelena");
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: Last Name is required");
        checkoutPage.getLastNameField().sendKeys("Dinere");
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: Postal Code is required");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        driver.close();
    }
}


