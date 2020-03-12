package com.broadleafcommerce.script;

import com.broadleafcommerce.base.BaseClass;
import com.broadleafcommerce.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass
{
    public LoginPage loginPage;

    @BeforeMethod
    public void setUp()
    {
        initiation();
        loginPage = new LoginPage(driver);
    }
    @Test
    public void testLoginPage() throws InterruptedException
    {
        Thread.sleep(2000);
        loginPage.login(property.getProperty("email"), property.getProperty("password"));
    }
}
