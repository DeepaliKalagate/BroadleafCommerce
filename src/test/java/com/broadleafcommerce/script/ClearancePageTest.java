package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.ClearancePage;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.HotSaucePage;
import com.broadleafcommerce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClearancePageTest extends TestBase
{
    public LoginPage loginPage;
    public HomePage homePage;
    public ClearancePage clearancePage;

    public ClearancePageTest()
    {
        super();//Initialize super class constructor
    }

    @BeforeMethod()
    public void setUp()
    {
        initiation();
        clearancePage=new ClearancePage();
        loginPage = new LoginPage();
        homePage=loginPage.login(property.getProperty("email"),property.getProperty("password"));
        clearancePage=homePage.clickOnClearance();
    }

    @Test(priority = 1)
    public void verifyClearancePageText()
    {
        boolean clearancePageText=clearancePage.verifyClearancePageText();
        Assert.assertTrue(clearancePageText);
    }

   @Test(priority = 2)
   public void testTitle() throws InterruptedException
   {
       Thread.sleep(1000);
       String clearancePageTitle=clearancePage.verifyClearancePageTitle();
       Assert.assertEquals(clearancePageTitle,"Clearance - Test Site","Clearance page title not matched");
   }

    @Test(priority = 3)
    public void verifyClearancePageTest() throws InterruptedException
    {
        Thread.sleep(1000);
        clearancePage.verifyClearancePageFields();
        Thread.sleep(2000);
    }
}
