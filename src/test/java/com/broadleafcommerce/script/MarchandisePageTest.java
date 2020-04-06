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
public class MarchandisePageTest extends TestBase
{
    @BeforeMethod
    public void setLoginPage() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.setEmail("deepali.kalagate@thoughtworks.com");
        loginPage.setPassword("Mysweetfamily@333");
        loginPage.clickOnLogin();
        MerchandisePage merchandisePage=new MerchandisePage(driver);
        HomePage homePage=new HomePage(driver);
        merchandisePage=homePage.clickOnMerchandise();
    }


    /*@Test(priority = 1)
    public void verifyMerchandisePageTextAndTitle() throws InterruptedException
    {
        MerchandisePage merchandisePage=new MerchandisePage(driver);
        boolean merchandisePageText=merchandisePage.verifyMarchandisePageText();
        Assert.assertTrue(merchandisePageText);
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().equals("Merchandise - Test Site"));
    }*/

    @Test(priority = 2)
    public void verifyMerchandiseTest() throws InterruptedException
    {
        List<String> list=new ArrayList<>();
        HomePage homePage=new HomePage(driver);
        homePage.clickOnWomensMerchandise();
        MerchandisePage merchandisePage=new MerchandisePage(driver);
        merchandisePage.setSortBy();
        merchandisePage.setPrice();
        merchandisePage.setFilter();
        merchandisePage.setSilver();
        merchandisePage.setShirtImage();
        merchandisePage.setSelectSilver();
        merchandisePage.setShirtSize("M");
        merchandisePage.setAddToCart();

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

                driver.findElement(By.xpath("//a[@class='btn btn-primary goto-full-cart']")).click();
            }
        }
        driver.switchTo().window(MainWindow);

//        merchandisePage.verifyMerchandisePage();

        List<WebElement> productName =driver.findElements(By.xpath("//div[@class='col-sm-7']"));
        for (WebElement webElement:productName)
        {
            System.out.println(webElement.getText());
            list.add(webElement.getText());
        }
        System.out.println(list);
       // Assert.assertTrue(productName.contains("HAWT LIKE A HABANERO SHIRT (WOMEN'S) SILVER (MEDIUM)"),"Product name is incorrect");

        ShippingPage shippingPage=new ShippingPage(driver);
        shippingPage.setClickOnCheckout();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().equals("Broadleaf Commerce Demo Store - Heat Clinic - Checkout"));
        shippingPage.setFullName("fullName");
        shippingPage.setAddress1("address1");
        shippingPage.setAddress2("address2");
        shippingPage.setCity("city");
        Thread.sleep(500);
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
