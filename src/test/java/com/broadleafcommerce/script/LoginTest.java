package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Listener;
import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class LoginTest extends TestBase
{
    @Test
    public void broadleafLogoImageAndPageTitleTest()
    {
        LoginPage loginPage=new LoginPage(driver);
        boolean flag=loginPage.verifyLogoImage();
        Assert.assertTrue(flag);
        Assert.assertTrue(driver.getTitle().equals("Broadleaf Commerce Demo Store - Heat Clinic - Login"));
    }

    @Test
    public void loginTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage=new HomePage(driver);
        loginPage.setEmail(property.getProperty("email"));
        loginPage.setPassword(property.getProperty("password"));
        homePage=loginPage.clickOnLogin();
        Assert.assertTrue(homePage.verifyUserName());
    }
}
