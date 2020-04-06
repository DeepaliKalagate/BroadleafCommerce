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

    @Test(priority = 1)
    public void verifyHotSaucePageLable()
    {
        GiftCardPage giftCardPage=new GiftCardPage(driver);
        Assert.assertTrue(driver.getTitle().equals("Gift Cards - Test Site"));
    }

    @Test(priority = 2)
    public void selectHotSauceTest() throws InterruptedException
    {
        List<String> list=new ArrayList<>();
        Thread.sleep(1000);
        GiftCardPage giftCardPage=new GiftCardPage(driver);
        giftCardPage.setSelectGiftCard();
        giftCardPage.setPersonalMessage(property.getProperty("message"));
        giftCardPage.setSender(property.getProperty("name"));
        giftCardPage.setEmail(property.getProperty("recepeintEmail"));
        giftCardPage.setName(property.getProperty("recepeintName"));
        giftCardPage.setSelectColor();
        giftCardPage.setClickAddToCart();
        giftCardPage.setClickOnCart();
        giftCardPage.setGiftCard();

        List<WebElement> productName =driver.findElements(By.xpath("//div[@class='col-sm-7']"));
        for (WebElement webElement:productName)
        {
            System.out.println(webElement.getText());
            list.add(webElement.getText());
        }
        System.out.println(list);
        Assert.assertTrue(productName.contains("BLAZIN' SADDLE XXX HOT HABANERO PEPPER SAUCE"),"Product name is incorrect");

        ShippingPage shippingPage=new ShippingPage(driver);
        HomePage homePage=new HomePage(driver);
        shippingPage.setClickOnCheckout();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().equals("Broadleaf Commerce Demo Store - Heat Clinic - Checkout"));
        shippingPage.setFullName("fullName");
        shippingPage.setAddress1("address1");
        shippingPage.setAddress2("address2");
        shippingPage.setCity("city");
        shippingPage.setState("state");
        shippingPage.setPostal("postal");
        shippingPage.setPhoneNumber("mobileno");
        shippingPage.setShippingMethod();
        shippingPage.setClickToContinue();
        shippingPage.setCashOnDelivery();
        shippingPage.setContinueShopping();
        shippingPage.setPlaceOrder();
        homePage=shippingPage.verifyShippingPage();
        Assert.assertTrue(homePage.verifyUserName());
    }
}
