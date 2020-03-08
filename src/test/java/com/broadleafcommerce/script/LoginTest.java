package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Browser;
import com.broadleafcommerce.model.HotSausOrder;
import com.broadleafcommerce.model.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.broadleafcommerce.base.CustomListener.class)
public class LoginTest extends Browser
{
    @Test
    public void testLoginPage() throws InterruptedException
    {
        LoginPage loginPage=new LoginPage(driver);
        HotSausOrder hotSausOrder=new HotSausOrder(driver);
        Thread.sleep(1000);
        loginPage.setLogin();
        loginPage.setEmail("dipakalagate1991@gmail.com");
        loginPage.setPassword("Mysweetfamily@333");
        loginPage.setClickLogin();
        hotSausOrder.setHotSauses();
        hotSausOrder.setGetHotSauses();
        hotSausOrder.setViewDetails();
        hotSausOrder.setAddToCart();
    }
}
