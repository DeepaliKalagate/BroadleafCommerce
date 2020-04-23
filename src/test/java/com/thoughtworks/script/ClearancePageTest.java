package com.thoughtworks.script;
import com.thoughtworks.base.Listener;
import com.thoughtworks.base.TestBase;
import com.thoughtworks.pages.ClearancePage;
import com.thoughtworks.pages.HomePage;
import com.thoughtworks.pages.LoginPage;
import com.thoughtworks.pages.ShippingCart;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.List;

@Listeners(Listener.class)
public class ClearancePageTest extends TestBase
{
    @Test()
    public void verifyClearancePageTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(property.getProperty("email"), property.getProperty("password"));
        Assert.assertEquals(driver.findElement(By.className("material-icons")).isDisplayed(), true, "Verify Login is Successful");

        ClearancePage clearancePage;
        HomePage homePage = new HomePage(driver);
        clearancePage = homePage.clickOnClearance();
        Assert.assertTrue(driver.getTitle().equals("Clearance - Test Site"));

        clearancePage.searchProductByname("Blazin");
        clearancePage.selectSearchedProduct();
        clearancePage.selectProductImage();
        ShippingCart shippingCart = new ShippingCart(driver);
        String element = shippingCart.verifyItemIsPresentOrNot();
        if (element.equals("OUT OF STOCK"))
        {
            driver.navigate().back();
        }
        else
        {
            clearancePage.productAddToCart();
            List<String> addedProducts = shippingCart.getProductsAddedInCart();
            Assert.assertTrue(addedProducts.contains("BLAZIN' SADDLE XXX HOT HABANERO PEPPER SAUCE"), "Product name is incorrect");
        }
    }
}
