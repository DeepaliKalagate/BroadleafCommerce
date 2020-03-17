package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.LoginPage;
import com.broadleafcommerce.properties.Library;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase
{
    @Test
    public void broadleafLogoImageTest() throws InterruptedException
    {
        LoginPage loginPage = new LoginPage(driver);
        String title=loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Broadleaf Commerce Demo Store - Heat Clinic - Login");
        Thread.sleep(2000);
    }

    @Test
    public void loginTest() throws InterruptedException
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage=new HomePage(driver);
        homePage=loginPage.login("dipakalagate1991@gmail.com","Mysweetfamily@333");
    }
}
