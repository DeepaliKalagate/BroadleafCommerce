package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClearancePageTest extends TestBase
{
    @BeforeMethod
    public void setLoginPage() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("dipakalagate1991@gmail.com","Mysweetfamily@333");
        ClearancePage clearancePage=new ClearancePage(driver);
        HomePage homePage=new HomePage(driver);
        clearancePage=homePage.clickOnClearance();
    }

    @Test(priority = 1)
    public void verifyClearancePageTextAndTitle() throws InterruptedException
    {
        ClearancePage clearancePage=new ClearancePage(driver);
        boolean clearancePageText=clearancePage.verifyClearancePageText();
        Assert.assertTrue(clearancePageText);
        Thread.sleep(1000);
        String clearancePageTitle=clearancePage.verifyClearancePageTitle();
        Assert.assertEquals(clearancePageTitle,"Clearance - Test Site","Clearance page title not matched");
    }

    @Test(priority = 2)
    public void verifyClearancePageTest() throws InterruptedException
    {
        Thread.sleep(1000);
        ClearancePage clearancePage=new ClearancePage(driver);
        clearancePage.verifyClearancePageFields();
        Thread.sleep(2000);
        ShippingPage shippingPage=new ShippingPage(driver);
        shippingPage.VerifyShippingPage("Deepali Lokesh Patil","MG Road","Ramnagar","Thane","MH","45050","9870675890");
        Thread.sleep(1000);
    }
}
