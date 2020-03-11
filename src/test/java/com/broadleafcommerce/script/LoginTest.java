package com.broadleafcommerce.script;

import com.broadleafcommerce.base.BaseClass;
import com.broadleafcommerce.model.LoginPage;
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
        loginPage.login(property.getProperty("email"), property.getProperty("password"));
    }
}
