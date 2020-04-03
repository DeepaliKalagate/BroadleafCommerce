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
public class HotSauceTest extends TestBase
{
    @BeforeMethod
    public void setLoginPage() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("deepali.kalagate@thoughtworks.com","Mysweetfamily@333");
        HotSaucePage hotSausPage=new HotSaucePage(driver);
        HomePage homePage=new HomePage(driver);
        hotSausPage=homePage.clickOnHotsauce();
    }

    @Test(priority = 1)
    public void verifyHotSaucePageLableAndTitle() throws InterruptedException
    {
        HomePage homePage=new HomePage(driver);
        HotSaucePage hotSausPage=homePage.clickOnHotsauce();
        boolean hotSaucePageLable=hotSausPage.verifyHotSaucePageLable();
        Assert.assertTrue(hotSaucePageLable);
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().equals("Hot Sauces - Test Site"));
    }

    @Test(priority = 2)
    public void selectHotSauceTest() throws InterruptedException
    {
        Thread.sleep(1000);
        HomePage homePage=new HomePage(driver);
        HotSaucePage hotSausPage=homePage.clickOnHotsauce();
        hotSausPage.verifyToShowHotSauses("Green Ghost");
        Assert.assertTrue(driver.getTitle().equals("Broadleaf Commerce Demo Store - Heat Clinic - Cart"));
        Thread.sleep(2000);
        ShippingPage shippingPage=new ShippingPage(driver);
        shippingPage.setClickOnCheckout();
        Thread.sleep(500);
        shippingPage.verifyShippingPage("Deepali Lokesh Patil","MG Road","Ramnagar","Thane","MH","45050","9870675890");
        Thread.sleep(1000);
    }
}
