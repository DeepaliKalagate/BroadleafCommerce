package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.LoginPage;
import com.broadleafcommerce.pages.MerchandisePage;
import com.broadleafcommerce.pages.ShippingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MarchandisePageTest extends TestBase
{
    public LoginPage loginPage;
    public HomePage homePage;
    public MerchandisePage merchandisePage;
    public ShippingPage shippingPage;

    public MarchandisePageTest()
    {
        super();//Initialize super class constructor
    }

    @BeforeMethod()
    public void setUp() throws InterruptedException
    {
        initiation();
        merchandisePage=new MerchandisePage();
        loginPage = new LoginPage();
        shippingPage=new ShippingPage();
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
        Thread.sleep(2000);
        shippingPage.VerifyShippingPage("Deepali Lokesh Patil","MG Road","Ramnagar","Thane","MH","45050","9870675890");
        Thread.sleep(1000);
    }
}
