package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MarchandiseRemoveFromCartPageTest extends TestBase
{
    public LoginPage loginPage;
    public HomePage homePage;
    public MerchandisePage merchandisePage;
    public MerchandiseRemoveFromCartPage removeFromCartPage;


    public MarchandiseRemoveFromCartPageTest()
    {
        super();//Initialize super class constructor
    }

    @BeforeMethod()
    public void setUp() throws InterruptedException
    {
        initiation();
        removeFromCartPage=new MerchandiseRemoveFromCartPage();
        loginPage = new LoginPage();
        homePage=loginPage.login(property.getProperty("email"),property.getProperty("password"));
        merchandisePage=homePage.clickOnMerchandise();
    }

    @Test(priority = 1)
    public void verifyMerchandisePageText()
    {
        boolean merchandisePageText=removeFromCartPage.verifyMarchandisePageText();
        Assert.assertTrue(merchandisePageText);
    }

    @Test(priority = 2)
    public void testTitle() throws InterruptedException
    {
        Thread.sleep(1000);
        String merchandisePageTitle=removeFromCartPage.verifyMerchandisePageTitle();
        Assert.assertEquals(merchandisePageTitle,"Merchandise - Test Site","Merchandise page title not matched");
    }

    @Test(priority = 3)
    public void verifyMerchandiseTest() throws InterruptedException
    {
        Thread.sleep(1000);
        homePage.clickOnWomensMerchandise();
        removeFromCartPage.setMerchandisePageFields("M");
        Thread.sleep(2000);
    }
}
