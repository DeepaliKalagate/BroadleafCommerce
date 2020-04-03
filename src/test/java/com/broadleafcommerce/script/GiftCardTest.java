package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Listener;
import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class GiftCardTest extends TestBase
{
   @BeforeMethod
    public void setLoginPage() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("deepali.kalagate@thoughtworks.com","Mysweetfamily@333");
        GiftCardPage giftCardPage=new GiftCardPage(driver);
        HomePage homePage=new HomePage(driver);
        giftCardPage=homePage.clickOnGiftCard();
    }

    @Test(priority = 1)
    public void verifyHotSaucePageLable()
    {
        GiftCardPage giftCardPage=new GiftCardPage(driver);
        Assert.assertTrue(driver.getTitle().equals("Gift Cards - Test Site"));
    }

    @Test(priority = 2)
    public void selectHotSauceTest() throws InterruptedException
    {
        Thread.sleep(1000);
        GiftCardPage giftCardPage=new GiftCardPage(driver);
        giftCardPage.setGiftCard("Diwali Gift","Deepali","lokesh.patil1984@gmail.com","Lokesh Patil");
        Assert.assertTrue(driver.getTitle().equals("Broadleaf Commerce Demo Store - Heat Clinic - Cart"));
        Thread.sleep(2000);
        ShippingPage shippingPage=new ShippingPage(driver);
        shippingPage.setClickOnCheckout();
        Thread.sleep(500);
        shippingPage.verifyShippingPage("Deepali Lokesh Patil","MG Road","Ramnagar","Thane","MH","45050","9870675890");
        Thread.sleep(1000);
    }
}
