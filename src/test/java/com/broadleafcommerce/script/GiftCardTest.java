package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GiftCardTest extends TestBase
{
    public GiftCardPage giftCardPage;
    public LoginPage loginPage;
    public HomePage homePage;
    public ShippingPage shippingPage;

    public GiftCardTest()
    {
        super();//Initialize super class constructor
    }

    @BeforeMethod()
    public void setUp() throws InterruptedException
    {
        initiation();
        giftCardPage=new GiftCardPage();
        loginPage = new LoginPage();
        shippingPage=new ShippingPage();
        homePage=loginPage.login(property.getProperty("email"),property.getProperty("password"));
        giftCardPage=homePage.clickOnGiftCard();
    }

    @Test(priority = 1)
    public void verifyHotSaucePageLable()
    {
        String giftCardPageTitle=giftCardPage.verifyGiftCardPageTitle();
        Assert.assertEquals(giftCardPageTitle,"Gift Cards - Test Site","Gift Card page title not matched");
    }

    @Test(priority = 2)
    public void selectHotSauceTest() throws InterruptedException
    {
        Thread.sleep(1000);
        giftCardPage.setGiftCard("Diwali Gift","Deepali","lokesh.patil1984@gmail.com","Lokesh Patil");
        Thread.sleep(2000);
        shippingPage.VerifyShippingPage("Deepali Lokesh Patil","MG Road","Ramnagar","Thane","MH","45050","9870675890");
        Thread.sleep(1000);
    }


}
