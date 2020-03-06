package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Browser;
import com.broadleafcommerce.model.RegisterPage;
import org.testng.annotations.Test;

public class BroadLeafCommerceTest extends Browser
{
    @Test
    public void givenURL_WhenValid_ThenShouldLaunchSuccessfully() throws InterruptedException
    {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.setLogin();
        Thread.sleep(500);
        registerPage.setEmail("dipakalagate1991@gmail.com");
        Thread.sleep(500);
        registerPage.setFirstName("Deepali");
        registerPage.setLastName("Patil");
        registerPage.setPassword("jaisai12");
        registerPage.setConfirmPassword("jaisai12");
        registerPage.setClickRegister();
    }
}
