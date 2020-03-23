package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Listener;
import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.HotSaucePage;
import com.broadleafcommerce.pages.LoginPage;
import com.broadleafcommerce.pages.ShippingPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class ShippingPageTest extends TestBase
{
   @BeforeMethod
    public void setLoginPage() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("dipakalagate1991@gmail.com","Mysweetfamily@333");
        HotSaucePage hotSaucePage=new HotSaucePage(driver);
        HomePage homePage=new HomePage(driver);
        hotSaucePage=homePage.clickOnHotsauce();
        ShippingPage shippingPage=new ShippingPage(driver);
        shippingPage=hotSaucePage.verifyToShowHotSauses("Green Ghost");
    }

    @Test
    public void verifyShippingPageTest() throws InterruptedException
    {
        Thread.sleep(2000);
        ShippingPage shippingPage=new ShippingPage(driver);
        shippingPage.VerifyShippingPage("Deepali Lokesh Patil","MG Road","Ramnagar","Thane","MH","45050","9870675890");

    }
}
