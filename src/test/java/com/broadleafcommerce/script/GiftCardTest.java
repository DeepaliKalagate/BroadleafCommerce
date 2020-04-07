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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Listeners(Listener.class)
public class GiftCardTest extends TestBase
{
   @BeforeMethod
    public void setLoginPage() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.setEmail("deepali.kalagate@thoughtworks.com");
        loginPage.setPassword("Mysweetfamily@333");
        loginPage.clickOnLogin();
        GiftCardPage giftCardPage=new GiftCardPage(driver);
        HomePage homePage=new HomePage(driver);
        giftCardPage=homePage.clickOnGiftCard();
    }

   /* @Test(priority = 1)
    public void verifyHotSaucePageLable()
    {
        GiftCardPage giftCardPage=new GiftCardPage(driver);
        Assert.assertTrue(driver.getTitle().equals("Gift Cards - Test Site"));
    }
*/
    @Test(priority = 2)
    public void selectHotSauceTest() throws InterruptedException
    {
        List<String> list=new ArrayList<>();
        GiftCardPage giftCardPage=new GiftCardPage(driver);
        giftCardPage.setSelectGiftCard();
        giftCardPage.setPersonalMessage(property.getProperty("message"));
        giftCardPage.setSender(property.getProperty("name"));
        giftCardPage.setEmail(property.getProperty("recepeintEmail"));
        giftCardPage.setName(property.getProperty("recepeintName"));
        giftCardPage.setSelectColor();
        giftCardPage.setClickAddToCart();
        Thread.sleep(1000);

        String MainWindow=driver.getWindowHandle();
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();

        while(i1.hasNext())
        {
            String ChildWindow=i1.next();

            if(!MainWindow.equalsIgnoreCase(ChildWindow))
            {
                // Switching to Child window
                driver.switchTo().window(ChildWindow);

                driver.findElement(By.className("btn btn-primary goto-full-cart")).click();
            }
        }
        driver.switchTo().window(MainWindow);
        List<WebElement> productName =driver.findElements(By.xpath("//div[@class='card checkout-card cart-summary-row']"));
        for (WebElement webElement:productName)
        {
            System.out.println(webElement.getText());
            list.add(webElement.getText());
        }
        System.out.println(list);
        Assert.assertTrue(productName.contains("$5 Gift Card"),"Product name is incorrect");

        ShippingPage shippingPage=new ShippingPage(driver);
        HomePage homePage=new HomePage(driver);
        shippingPage.setClickOnCheckout();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().equals("Broadleaf Commerce Demo Store - Heat Clinic - Checkout"));
        homePage=shippingPage.VerifyShippingPage(property.getProperty("fullName"),
                property.getProperty("address1"),property.getProperty("address2"),
                property.getProperty("city"),property.getProperty("state"),
                property.getProperty("postal"),property.getProperty("mobileno"));
        Assert.assertTrue(homePage.verifyUserName());
    }
}
