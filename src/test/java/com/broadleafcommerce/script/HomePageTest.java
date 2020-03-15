package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.HotSaucePage;
import com.broadleafcommerce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase
{
    public LoginPage loginPage;
    public HomePage homePage;
    public HotSaucePage hotSaucePage;
    public HomePageTest()
    {
        super();//Initialize super class constructor
    }

    @BeforeMethod()
    public void setUp() throws InterruptedException
    {
        initiation();
        hotSaucePage =new HotSaucePage();
        loginPage = new LoginPage();
        homePage=loginPage.login(property.getProperty("email"),property.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyUserNameTest()
    {
        boolean userName=homePage.verifyUserName();
        Assert.assertTrue(userName);
    }

    @Test(priority = 2)
    public void verifyHotSauceLinkTest()
    {
       hotSaucePage = homePage.clickOnHotsauce();
    }
}
