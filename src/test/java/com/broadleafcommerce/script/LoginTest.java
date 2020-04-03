package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Listener;
import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.LoginPage;
import com.broadleafcommerce.properties.Library;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class LoginTest extends TestBase
{
    @Test(priority = 1)
    public void broadleafLogoImageTest() throws InterruptedException
    {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(driver.getTitle().equals("Broadleaf Commerce Demo Store - Heat Clinic - Login"));
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void loginTest() throws InterruptedException
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage=new HomePage(driver);
        homePage=loginPage.login("deepali.kalagate@thoughtworks.com","Mysweetfamily@333");
    }
}
