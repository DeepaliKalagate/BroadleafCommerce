package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Listener;
import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.HotSaucePage;
import com.broadleafcommerce.pages.LoginPage;
import com.broadleafcommerce.pages.ShippingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Listeners(Listener.class)
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

    /*@Test(priority = 1)
    public void verifyHotSaucePageLableAndTitle() throws InterruptedException
    {
        HomePage homePage=new HomePage(driver);
        HotSaucePage hotSausPage=homePage.clickOnHotsauce();
        boolean hotSaucePageLable=hotSausPage.verifyHotSaucePageLable();
        Assert.assertTrue(hotSaucePageLable);
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().equals("Hot Sauces - Test Site"));
    }*/

    @Test(priority = 2)
    public void selectHotSauceTest() throws InterruptedException
    {
        List<String> list=new ArrayList<>();
        HomePage homePage=new HomePage(driver);
        HotSaucePage hotSaucePage=new HotSaucePage(driver);

        hotSaucePage.setManufacturer();
        hotSaucePage.setSelectManufacturer();
        hotSaucePage.setHeatRange();
        hotSaucePage.setSelectHeatRange();
        hotSaucePage.setPrice();
        hotSaucePage.setSelectPrice();

        hotSaucePage.setViewHotSuace();
            hotSaucePage.setQuickViewOfHotSauce();
            hotSaucePage.setAddToCart();
            hotSaucePage.verifyToShowHotSauses();

            List<WebElement> productName =driver.findElements(By.xpath("//div[@id='cart']"));
            for (WebElement webElement:productName)
            {
                System.out.println(webElement.getText());
                list.add(webElement.getText());
            }
            System.out.println(list);
            Assert.assertTrue(productName.contains("GREEN GHOST"),"Product name is incorrect");

            ShippingPage shippingPage=new ShippingPage(driver);
            shippingPage.setClickOnCheckout();
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
