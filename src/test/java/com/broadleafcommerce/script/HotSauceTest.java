package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.HotSaucePage;
import com.broadleafcommerce.pages.LoginPage;
import com.broadleafcommerce.pages.ShippingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotSauceTest extends TestBase
{
    public LoginPage loginPage;
    public HomePage homePage;
    public HotSaucePage hotSausPage;
    public ShippingPage shippingPage;

    public HotSauceTest()
    {
        super();//Initialize super class constructor
    }

    @BeforeMethod()
    public void setUp() throws InterruptedException
    {
        initiation();
        hotSausPage=new HotSaucePage();
        loginPage = new LoginPage();
        shippingPage=new ShippingPage();
        homePage=loginPage.login(property.getProperty("email"),property.getProperty("password"));
        hotSausPage=homePage.clickOnHotsauce();
    }

    @Test(priority = 1)
    public void verifyHotSaucePageLable()
    {
        boolean hotSaucePageLable=hotSausPage.verifyHotSaucePageLable();
        Assert.assertTrue(hotSaucePageLable);
    }

    @Test(priority = 2)
    public void selectHotSauceTest() throws InterruptedException
    {
        Thread.sleep(1000);
        hotSausPage.verifyToShowHotSauses("Green Ghost");
        Thread.sleep(2000);
        shippingPage.VerifyShippingPage("Deepali Lokesh Patil","MG Road","Ramnagar","Thane","MH","45050","9870675890");
        Thread.sleep(1000);
    }

    @Test
    public void verifyHotSaucePageTitle() throws InterruptedException
    {
        Thread.sleep(1000);
        String hotSaucePageTitle=hotSausPage.verifyHotSaucePageTitle();
        Assert.assertEquals(hotSaucePageTitle,"Hot Sauces - Test Site","Home page title not matched");
    }
}
