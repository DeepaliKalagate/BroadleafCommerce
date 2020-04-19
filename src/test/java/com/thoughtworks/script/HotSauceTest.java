package com.thoughtworks.script;

import com.thoughtworks.base.TestBase;
import com.thoughtworks.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class HotSauceTest extends TestBase
{
    @Test()
    public void hotSauceTest() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(driver.findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");

        HotSaucePage hotSausPage=new HotSaucePage(driver);
        HomePage homePage=new HomePage(driver);
        hotSausPage=homePage.clickOnHotsauce();
        Assert.assertTrue(driver.getTitle().equals("Hot Sauces - Test Site"));

        HotSauce hotSauce=new HotSauce(driver);
        hotSauce.viewHotSuaceProduct();
        Thread.sleep(500);
        ShippingCart shippingCart=new ShippingCart(driver);
        String element=shippingCart.verifyItemIsPresentOrNot();
        if(element.equals("OUT OF STOCK"))
        {
            driver.navigate().back();
        }
        else
        {
            hotSauce.productAddToCart();
            List<String> addedProducts = shippingCart.getProductsAddedInCart();
            Assert.assertTrue(addedProducts.contains("COOL CAYENNE PEPPER HOT SAUCE"),"Product name is incorrect");
        }
    }
}
