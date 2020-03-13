package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.HotSaucePage;
import com.broadleafcommerce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotSauceTest extends TestBase
{
    public LoginPage loginPage;
    public HomePage homePage;
    public HotSaucePage hotSausPage;

    public HotSauceTest()
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
    }
    @Test(priority = 1)
    public void verifyHomePageTitle()
    {
        String hotSaucePageTitle=hotSausPage.verifyHotSaucePageTitle();
        Assert.assertEquals(hotSaucePageTitle,"Hot Sauces - Test Site","Home page title not matched");
    }

    @Test(priority = 2)
    public void verifyHotSaucePageLable()
    {
        boolean hotSaucePageLable=hotSausPage.verifyHotSaucePageLable();
        Assert.assertTrue(hotSaucePageLable);
    }

    @Test(priority = 3)
    public void selectHotSauceTest() throws InterruptedException
    {
        hotSausPage.setGetHotSauses();
        Thread.sleep(1000);
    }
}
