package com.thoughtworks.script;

import com.thoughtworks.base.BaseTest;
import com.thoughtworks.base.Listener;
import com.thoughtworks.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(Listener.class)
public class HotSaucePageTest extends BaseTest
{
    @Test()
    public void selectHotSauceTest() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(driver.findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");

        HotSaucePage hotSaucePage=new HotSaucePage(driver);
        HomePage homePage=new HomePage(driver);
        hotSaucePage=homePage.clickOnHotsauce();
        Assert.assertTrue(driver.getTitle().equals("Hot Sauces - Test Site"));


        ProductListingPage productListingPage=new ProductListingPage(driver);
        productListingPage.selectSortBy();

        hotSaucePage.selectFilterBy();
        hotSaucePage.selectProductImage();
        Thread.sleep(500);

        ShippingCart shippingCart=new ShippingCart(driver);
        String element=shippingCart.verifyItemIsPresentOrNot();
        if(element.equals("OUT OF STOCK"))
        {
            driver.navigate().back();
        }
        else
        {
            hotSaucePage.productAddToCart();
            List<String> addedProducts = shippingCart.getProductsAddedInCart();
            Assert.assertTrue(addedProducts.contains("BULL SNORT COWBOY CAYENNE PEPPER HOT SAUCE"),"Product name is incorrect");
        }
    }
}
