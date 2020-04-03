package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Listener;
import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class MarchandisePageTest extends TestBase
{
    @BeforeMethod
    public void setLoginPage() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("deepali.kalagate@thoughtworks.com","Mysweetfamily@333");
        MerchandisePage merchandisePage=new MerchandisePage(driver);
        HomePage homePage=new HomePage(driver);
        merchandisePage=homePage.clickOnMerchandise();
    }


    @Test(priority = 1)
    public void verifyMerchandisePageTextAndTitle() throws InterruptedException
    {
        MerchandisePage merchandisePage=new MerchandisePage(driver);
        boolean merchandisePageText=merchandisePage.verifyMarchandisePageText();
        Assert.assertTrue(merchandisePageText);
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().equals("Merchandise - Test Site"));
    }

    @Test(priority = 2)
    public void verifyMerchandiseTest() throws InterruptedException
    {
        Thread.sleep(1000);
        HomePage homePage=new HomePage(driver);
        homePage.clickOnWomensMerchandise();
        MerchandisePage merchandisePage=new MerchandisePage(driver);
        merchandisePage.setMerchandisePageFields("M");
        Assert.assertTrue(driver.getTitle().equals("Broadleaf Commerce Demo Store - Heat Clinic - Cart"));
        Thread.sleep(2000);
        ShippingPage shippingPage=new ShippingPage(driver);
        shippingPage.setClickOnCheckout();
        Thread.sleep(500);
        shippingPage.verifyShippingPage("Deepali Lokesh Patil","MG Road","Ramnagar","Thane","MH","45050","9870675890");
        Thread.sleep(1000);
    }
}
