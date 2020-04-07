package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Listener;
import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.HotSaucePage;
import com.broadleafcommerce.pages.LoginPage;
import com.broadleafcommerce.pages.ShippingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class ShippingPageTest extends TestBase
{
   @BeforeMethod
    public void setLoginPage() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.setEmail(property.getProperty("email"));
        loginPage.setPassword(property.getProperty("password"));
        loginPage.clickOnLogin();
        HotSaucePage hotSaucePage=new HotSaucePage(driver);
        ShippingPage shippingPage;
        hotSaucePage.setViewHotSuace();
        hotSaucePage.setQuickViewOfHotSauce();
        hotSaucePage.setAddToCart();
        shippingPage=hotSaucePage.verifyToShowHotSauses();
    }

    @Test()
    public void verifyShippingPageTest() throws InterruptedException
    {
        ShippingPage shippingPage=new ShippingPage(driver);
        HomePage homePage=new HomePage(driver);
        shippingPage.setClickOnCheckout();
        Assert.assertTrue(driver.getTitle().equals("Broadleaf Commerce Demo Store - Heat Clinic - Checkout"));
        homePage=shippingPage.VerifyShippingPage(property.getProperty("fullName"),
                property.getProperty("address1"),property.getProperty("address2"),
                property.getProperty("city"),property.getProperty("state"),
                property.getProperty("postal"),property.getProperty("mobileno"));
        Assert.assertTrue(homePage.verifyUserName());
    }
}
