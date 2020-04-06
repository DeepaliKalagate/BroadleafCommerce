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
        loginPage.setEmail("deepali.kalagate@thoughtworks.com");
        loginPage.setPassword("Mysweetfamily@333");
        loginPage.login();
        HotSaucePage hotSaucePage=new HotSaucePage(driver);
        ShippingPage shippingPage=new ShippingPage(driver);
        hotSaucePage.setSearchSauce("Green Ghost");
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
        homePage=shippingPage.verifyShippingPage("Deepali Lokesh Patil","MG Road","Ramnagar","Thane","MH","45050","9870675890");
        Assert.assertTrue(homePage.verifyUserName());
    }
}
