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

   /* @Test(priority = 1)
    public void verifyHotSaucePageLableAndTitle() throws InterruptedException
    {
        HomePage homePage=new HomePage(driver);
        HotSaucePage hotSausPage=homePage.clickOnHotsauce();
        boolean hotSaucePageLable=hotSausPage.verifyHotSaucePageLable();
        Assert.assertTrue(hotSaucePageLable);
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().equals("Hot Sauces - Test Site"));
    }
*/
    @Test(priority = 2)
    public void selectHotSauceTest() throws InterruptedException
    {
        List<String> list=new ArrayList<>();
        HomePage homePage=new HomePage(driver);
        HotSaucePage hotSaucePage=new HotSaucePage(driver);

        hotSaucePage.setSortBy();
        hotSaucePage.setPrice();
        hotSaucePage.setManufacturer();
        hotSaucePage.setSelectManufacturer();
        hotSaucePage.setHeatRange();
        hotSaucePage.setSelectHeatRange();

        hotSaucePage.setViewHotSuace();
        hotSaucePage.setAddToCart();

        hotSaucePage.verifyToShowHotSauses();
        List<WebElement> productName =driver.findElements(By.id("cart"));
        for (WebElement webElement:productName)
        {
            System.out.println(webElement.getText());
            list.add(webElement.getText());
        }
        System.out.println(list);
        //Assert.assertTrue(productName.contains("Cool Cayenne Pepper Hot Sauce"),"Product name is incorrect");

        ShippingPage shippingPage=new ShippingPage(driver);
        shippingPage.setClickOnCheckout();
        Assert.assertTrue(driver.getTitle().equals("Broadleaf Commerce Demo Store - Heat Clinic - Checkout"));
        homePage=shippingPage.VerifyShippingPage(property.getProperty("fullName"),
                    property.getProperty("address1"),property.getProperty("address2"),
                    property.getProperty("city"),property.getProperty("state"),
                    property.getProperty("postal"),property.getProperty("mobileno"));
        Assert.assertTrue(homePage.verifyUserName());
    }
}
