package com.thoughtworks.script;
import com.thoughtworks.base.BaseTest;
import com.thoughtworks.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class ProductRemoveFromCartTest extends BaseTest
{
    @Test
    public void productRemoveFromCartTest() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(driver.findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");
        ClearancePage clearancePage=new ClearancePage(driver);
        HomePage homePage=new HomePage(driver);
        clearancePage=homePage.clickOnClearance();
        Assert.assertTrue(driver.getTitle().equals("Clearance - Test Site"));

        ProductRemoveFromCartPage removeFromCartPage=new ProductRemoveFromCartPage(driver);
        removeFromCartPage.selectProduct();
        Thread.sleep(5000);
        ShippingCart shippingCart=new ShippingCart(driver);
        String element=shippingCart.verifyItemIsPresentOrNot();
        if(element.equals("OUT OF STOCK"))
        {
            driver.navigate().back();
        }
        else
        {
            removeFromCartPage.productAddToCart();
            List<String> addedProducts = shippingCart.getProductsAddedInCart();
            Assert.assertTrue(addedProducts.contains("BLAZIN' SADDLE XXX HOT HABANERO PEPPER SAUCE"),"Product name is incorrect");

            for (int i=0;i<addedProducts.size();i++)
            {
                removeFromCartPage.removeProdutsFromCart();
                Thread.sleep(500);
            }
            removeFromCartPage.clickOnDropdown();
            removeFromCartPage.clickOnLogout();
            Assert.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'Login')]"))
                    .isDisplayed(), true,"Verify Logout Successful");
        }
    }
}
