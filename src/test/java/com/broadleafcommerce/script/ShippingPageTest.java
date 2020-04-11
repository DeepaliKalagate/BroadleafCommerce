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
    public void setLoginPage()
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.setEmail(property.getProperty("email"));
        loginPage.setPassword(property.getProperty("password"));
        loginPage.clickOnLogin();
        HotSaucePage hotSaucePage=new HotSaucePage(driver);
        ShippingPage shippingPage;
        hotSaucePage.setViewHotSuace();
        shippingPage=hotSaucePage.verifyToShowHotSauses();
    }

    @Test()
    public void verifyShippingPageTest()
    {
        ShippingPage shippingPage=new ShippingPage(driver);
        HomePage homePage=new HomePage(driver);
        homePage=shippingPage.VerifyShippingPage(property.getProperty("fullName"),
                property.getProperty("address1"),property.getProperty("address2"),
                property.getProperty("city"),property.getProperty("state"),
                property.getProperty("postal"),property.getProperty("mobileno"));
        Assert.assertTrue(homePage.verifyUserName());
    }
}
