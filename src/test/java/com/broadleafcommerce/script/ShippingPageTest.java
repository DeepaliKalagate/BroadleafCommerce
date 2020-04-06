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
        ShippingPage shippingPage=new ShippingPage(driver);
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
        shippingPage.setFullName("fullName");
        shippingPage.setAddress1("address1");
        shippingPage.setAddress2("address2");
        shippingPage.setCity("city");
        shippingPage.setState("MH");
        shippingPage.setPostal("postal");
        shippingPage.setPhoneNumber("mobileno");
        shippingPage.setShippingMethod();
        shippingPage.setClickToContinue();
        shippingPage.setCashOnDelivery();
        shippingPage.setContinueShopping();
        shippingPage.setPlaceOrder();
        homePage=shippingPage.verifyShippingPage();
        Assert.assertTrue(homePage.verifyUserName());
    }
}
