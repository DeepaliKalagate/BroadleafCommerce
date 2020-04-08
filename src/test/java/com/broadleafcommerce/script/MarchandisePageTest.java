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
    public void setLoginPage()
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.setEmail("deepali.kalagate@thoughtworks.com");
        loginPage.setPassword("Mysweetfamily@333");
        loginPage.clickOnLogin();
        MerchandisePage merchandisePage=new MerchandisePage(driver);
        HomePage homePage=new HomePage(driver);
        merchandisePage=homePage.clickOnMerchandise();
    }

    @Test(priority = 1)
    public void verifyMerchandisePageTextAndTitle()
    {
        MerchandisePage merchandisePage=new MerchandisePage(driver);
        boolean merchandisePageText=merchandisePage.verifyMarchandisePageText();
        Assert.assertTrue(merchandisePageText);
        Assert.assertTrue(driver.getTitle().equals("Merchandise - Test Site"));
    }

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

                driver.findElement(By.className("btn btn-primary goto-full-cart")).click();
            }
        }
        //witching to Parent Window
        driver.switchTo().window(MainWindow);

        //Getting list of Items from Cart
        List<WebElement> productName =driver.findElements(By.xpath("//div[@class='card checkout-card cart-summary-row']"));
        for (WebElement webElement:productName)
        {
            System.out.println(webElement.getText());
            list.add(webElement.getText());
        }
        System.out.println(list);
       Assert.assertTrue(list.contains("HAWT LIKE A HABANERO SHIRT (WOMEN'S) SILVER (MEDIUM)"),"Product name is incorrect");

        ShippingPage shippingPage=new ShippingPage(driver);
        homePage=shippingPage.VerifyShippingPage(property.getProperty("fullName"),
                property.getProperty("address1"),property.getProperty("address2"),
                property.getProperty("city"),property.getProperty("state"),
                property.getProperty("postal"),property.getProperty("mobileno"));
        Assert.assertTrue(homePage.verifyUserName());
    }
}
