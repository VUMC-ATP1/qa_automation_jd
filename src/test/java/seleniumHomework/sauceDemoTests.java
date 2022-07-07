package seleniumHomework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.CartPage;
import pageObjectsHomework.CheckoutPage;
import pageObjectsHomework.InventoryPage;
import pageObjectsHomework.LoginPage;

public class sauceDemoTests {
    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CheckoutPage checkoutPage;
    CartPage cartPage;
    private final String SAUCE_URL = "https://www.saucedemo.com/";
    private final String SAUCE_URL_INVENTORY = "https://www.saucedemo.com/inventory.html";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
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
        loginPage.getUserNameField().sendKeys("performance_glitch_user");
        loginPage.getPasswordField().sendKeys("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), SAUCE_URL_INVENTORY);
        //add one product
        inventoryPage.addSauceLabsBikeLight();
        inventoryPage.clickShoppingCartIcon();
        Assert.assertEquals(cartPage.getProductName().getText(), "Sauce Labs Bike Light");
        //checkout section
        checkoutPage.getFirstNameField().sendKeys("Jelena");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        driver.close();
    }
}


