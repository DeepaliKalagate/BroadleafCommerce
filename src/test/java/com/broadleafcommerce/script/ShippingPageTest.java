package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.HotSaucePage;
import com.broadleafcommerce.pages.LoginPage;
import com.broadleafcommerce.pages.ShippingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShippingPageTest extends TestBase
{
    public LoginPage loginPage;
    public HomePage homePage;
    public HotSaucePage hotSausPage;
    public ShippingPage shippingPage;

    public ShippingPageTest()
    {
        super();//Initialize super class constructor
    }

    @BeforeMethod()
    public void setUp()
    {
        initiation();
        hotSausPage=new HotSaucePage();
        loginPage = new LoginPage();
        homePage=loginPage.login(property.getProperty("email"),property.getProperty("password"));
        hotSausPage=homePage.clickOnHotsauce();
        shippingPage=hotSausPage.verifyToShowHotSauses();
    }

    @Test
    public void verifyShippingPageTest()
    {
        boolean shippingPageText=shippingPage.verifyShippingPageText();
        Assert.assertTrue(shippingPageText);
    }

    public void verifyShippingPage() throws InterruptedException
    {
        Thread.sleep(2000);
        shippingPage.VerifyShippingPage("Deepali Lokesh Patil","MG Road","Ramnagar","Thane","MH","45050","9870675890");
        Thread.sleep(1000);
        String shippingPageTitle=hotSausPage.verifyHotSaucePageTitle();
        Assert.assertEquals(shippingPageTitle,"Broadleaf Commerce Demo Store - Heat Clinic - Checkout","Home page title not matched");
        Thread.sleep(1000);
    }
}
