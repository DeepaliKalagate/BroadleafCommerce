package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Listener;
import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Listeners(Listener.class)
public class ClearancePageTest extends TestBase
{
    @BeforeMethod
    public void setLoginPage() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.setEmail("deepali.kalagate@thoughtworks.com");
        loginPage.setPassword("Mysweetfamily@333");
        loginPage.login();
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
        Assert.assertTrue(driver.getTitle().equals("Clearance - Test Site"));
    }

    @Test(priority = 2)
    public void verifyClearancePageTest() throws InterruptedException
    {
        List<String> list=new ArrayList<>();
        Thread.sleep(1000);
        ClearancePage clearancePage=new ClearancePage(driver);
        clearancePage.setClearanceItem();
        clearancePage.setAddToCart();
        clearancePage.verifyClearancePage();

        List<WebElement> productName =driver.findElements(By.xpath("//div[@class='col-sm-7']"));
        for (WebElement webElement:productName)
        {
            System.out.println(webElement.getText());
            list.add(webElement.getText());
        }
        System.out.println(list);
        Assert.assertTrue(productName.contains("BLAZIN' SADDLE XXX HOT HABANERO PEPPER SAUCE"),"Product name is incorrect");
        ShippingPage shippingPage=new ShippingPage(driver);
        HomePage homePage;
        shippingPage.setClickOnCheckout();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().equals("Broadleaf Commerce Demo Store - Heat Clinic - Checkout"));
        homePage=shippingPage.verifyShippingPage("Deepali Lokesh Patil","MG Road","Ramnagar","Thane","MH","45050","9870675890");
        Thread.sleep(1000);
        Assert.assertTrue(homePage.verifyUserName());
    }
}
