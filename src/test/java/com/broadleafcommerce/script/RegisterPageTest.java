package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase
{
    public RegisterPage registerPage;
    public HomePage homePage;

    public RegisterPageTest()
    {
        super();//Initialize super class constructor
    }

    @BeforeMethod
    public void setUp()
    {
        initiation();
        registerPage = new RegisterPage();
    }

    @Test(priority = 1)
    public void testRegisterPageTitle() throws InterruptedException
    {
        Thread.sleep(2000);
        String title=registerPage.validateRegisterPageTitle();
        Assert.assertEquals(title,"Broadleaf Commerce Demo Store - Heat Clinic - Login");
    }

    @Test(priority = 2)
    public void broadleafLogoImageTest()
    {
        boolean flag=registerPage.validateBroadleafLogoImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() throws InterruptedException
    {
        Thread.sleep(2000);
        homePage=registerPage.verifyRegisterPage(property.getProperty("email"),property.getProperty("firstName"),property.getProperty("lastName"),
                                                property.getProperty("password"),property.getProperty("confirmPassword"));
    }
}
