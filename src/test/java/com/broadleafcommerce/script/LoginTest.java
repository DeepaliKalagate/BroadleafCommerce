package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase
{
    public LoginPage loginPage;
    public HomePage homePage;

    public LoginTest()
    {
        super();//Initialize super class constructor
    }

    @BeforeMethod
    public void setUp()
    {
        initiation();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void broadleafLogoImageTest()
    {
        boolean flag=loginPage.validateBroadleafLogoImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void loginTest() throws InterruptedException
    {
        Thread.sleep(2000);
        String title=loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Broadleaf Commerce Demo Store - Heat Clinic - Login");
        Thread.sleep(2000);
        homePage=loginPage.login(property.getProperty("email"),property.getProperty("password"));
    }
}
