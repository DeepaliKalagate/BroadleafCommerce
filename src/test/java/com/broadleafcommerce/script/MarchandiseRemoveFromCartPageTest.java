package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MarchandiseRemoveFromCartPageTest extends TestBase
{
    @BeforeMethod
    public void setLoginPage() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("dipakalagate1991@gmail.com","Mysweetfamily@333");
        MerchandisePage merchandisePage=new MerchandisePage(driver);
        HomePage homePage=new HomePage(driver);
        merchandisePage=homePage.clickOnMerchandise();
    }

    @Test(priority = 1)
    public void verifyMerchandisePageTextAndTitle() throws InterruptedException
    {
        MerchandiseRemoveFromCartPage removeFromCartPage=new MerchandiseRemoveFromCartPage(driver);
        boolean merchandisePageText=removeFromCartPage.verifyMarchandisePageText();
        Assert.assertTrue(merchandisePageText);
        Thread.sleep(1000);
        String merchandisePageTitle=removeFromCartPage.verifyMerchandisePageTitle();
        Assert.assertEquals(merchandisePageTitle,"Merchandise - Test Site","Merchandise page title not matched");
    }

    @Test(priority = 2)
    public void verifyMerchandiseTest() throws InterruptedException
    {
        Thread.sleep(1000);
        HomePage homePage=new HomePage(driver);
        homePage.clickOnWomensMerchandise();
        MerchandiseRemoveFromCartPage removeFromCartPage=new MerchandiseRemoveFromCartPage(driver);
        removeFromCartPage.setMerchandisePageFields("M");
        Thread.sleep(2000);
    }
}
