package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.ClearancePage;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.LoginPage;
import com.broadleafcommerce.pages.MerchandisePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MarchandisePageTest extends TestBase
{
    public LoginPage loginPage;
    public HomePage homePage;
    public MerchandisePage merchandisePage;

    public MarchandisePageTest()
    {
        super();//Initialize super class constructor
    }

    @BeforeMethod()
    public void setUp()
    {
        initiation();
        merchandisePage=new MerchandisePage();
        loginPage = new LoginPage();
        homePage=loginPage.login(property.getProperty("email"),property.getProperty("password"));
        merchandisePage=homePage.clickOnMerchandise();
    }

    @Test(priority = 1)
    public void verifyMerchandisePageText()
    {
        boolean merchandisePageText=merchandisePage.verifyMarchandisePageText();
        Assert.assertTrue(merchandisePageText);
    }

    @Test(priority = 2)
    public void testTitle() throws InterruptedException
    {
        Thread.sleep(1000);
        String merchandisePageTitle=merchandisePage.verifyMerchandisePageTitle();
        Assert.assertEquals(merchandisePageTitle,"Merchandise - Test Site","Merchandise page title not matched");
    }

    @Test(priority = 3)
    public void verifyMerchandiseTest() throws InterruptedException
    {
        Thread.sleep(1000);
        homePage.clickOnWomensMerchandise();
        merchandisePage.setMerchandisePageFields("M");
        Thread.sleep(1000);
    }
}
