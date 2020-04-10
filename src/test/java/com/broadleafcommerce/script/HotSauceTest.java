package com.broadleafcommerce.script;

import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class HotSauceTest extends TestBase
{
    @BeforeMethod
    public void setLoginPage() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.setEmail(property.getProperty("email"));
        loginPage.setPassword(property.getProperty("password"));
        loginPage.clickOnLogin();
        HotSaucePage hotSausPage=new HotSaucePage(driver);
        HomePage homePage=new HomePage(driver);
        hotSausPage=homePage.clickOnHotsauce();
    }

    @Test(priority = 1)
    public void verifyHotSaucePageLableAndTitle() throws InterruptedException
    {

        HotSauce hotSauce=new HotSauce(driver);
        boolean hotSaucePageLable=hotSauce.verifyHotSaucePageLable();
        Assert.assertTrue(hotSaucePageLable);
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().equals("Hot Sauces - Test Site"));
    }
    @Test(priority = 2)
    public void hotSauceTest() throws InterruptedException
    {
        List<String> list=new ArrayList<>();
        HomePage homePage=new HomePage(driver);
        HotSauce hotSauce=new HotSauce(driver);
        hotSauce.setViewHotSauce();
        Thread.sleep(500);
        String element=driver.findElement(By.xpath("//div[@class='col-sm-10']//button[@class='btn']")).getText();
        System.out.println("Element Text is : "+element);
        if(element.equals("OUT OF STOCK"))
        {
            driver.navigate().back();
        }
        else
        {
            hotSauce.setAddToCart();
            hotSauce.verifyToShowHotSauses();
            List<WebElement> productName =driver.findElements(By.xpath("//div[@class='col-sm-7']"));
            for (WebElement webElement:productName)
            {
                System.out.println(webElement.getText());
                list.add(webElement.getText());
            }
            System.out.println(list);
            //Assert.assertEquals(productName,"COOL CAYENNE PEPPER HOT SAUCE","Product name is incorrect");
            ShippingPage shippingPage=new ShippingPage(driver);
            homePage=shippingPage.VerifyShippingPage(property.getProperty("fullName"),
                    property.getProperty("address1"),property.getProperty("address2"),
                    property.getProperty("city"),property.getProperty("state"),
                    property.getProperty("postal"),property.getProperty("mobileno"));
            Assert.assertTrue(homePage.verifyUserName());
        }
    }
}
