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
    @BeforeMethod
    public void setLoginPage() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("dipakalagate1991@gmail.com","Mysweetfamily@333");
    }

    @Test(priority = 1)
    public void verifyUserNameTest()
    {
        HomePage homePage=new HomePage(driver);
        boolean userName=homePage.verifyUserName();
        Assert.assertTrue(userName);
    }

    @Test(priority = 2)
    public void verifyHotSauceLinkTest()
    {
        HomePage homePage=new HomePage(driver);
        HotSaucePage hotSaucePage =new HotSaucePage(driver);
       hotSaucePage = homePage.clickOnHotsauce();
    }
}
