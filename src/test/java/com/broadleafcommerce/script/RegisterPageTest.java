package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.LoginPage;
import com.broadleafcommerce.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase
{
    @Test(priority = 1)
    public void broadleafLogoImageAndTitleTest() throws InterruptedException
    {
        RegisterPage registerPage=new RegisterPage(driver);
        boolean flag=registerPage.validateBroadleafLogoImage();
        Assert.assertTrue(flag);
        String title=registerPage.validateRegisterPageTitle();
        Assert.assertEquals(title,"Broadleaf Commerce Demo Store - Heat Clinic - Login");
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void verifyRegisterPageTest() throws InterruptedException
    {
        Thread.sleep(2000);
        RegisterPage registerPage=new RegisterPage(driver);
        HomePage homePage=new HomePage(driver);
        homePage=registerPage.verifyRegisterPage("deepali.kalagate@thoughtworks.com","Deepali","Patil",
                "Mysweetfamily@333","Mysweetfamily@333");
        Thread.sleep(2000);
    }
}
