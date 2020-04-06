package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Listener;
import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class RegisterPageTest extends TestBase
{
    @Test(priority = 1)
    public void broadleafLogoImageAndPageTitleTest()
    {
        RegisterPage registerPage=new RegisterPage(driver);
        boolean flag=registerPage.validateBroadleafLogoImage();
        Assert.assertTrue(flag);
        Assert.assertTrue(driver.getTitle().equals("Broadleaf Commerce Demo Store - Heat Clinic - Login"));
    }

    @Test(priority = 2)
    public void verifyRegisterPageTest()
    {
        RegisterPage registerPage=new RegisterPage(driver);
        HomePage homePage=new HomePage(driver);
        registerPage.setEmail("deepali.patil@thoughtworks.com");
        registerPage.setFirstName("Deepali");
        registerPage.setLastName("Patil");
        registerPage.setPassword("Mysweetfamily@333");
        registerPage.setConfirmPassword("Mysweetfamily@333");
        homePage=registerPage.verifyRegisterPage();
        Assert.assertTrue(homePage.verifyUserName());
    }
}
