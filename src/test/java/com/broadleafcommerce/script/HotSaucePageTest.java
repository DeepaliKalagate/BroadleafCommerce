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
public class HotSaucePageTest extends TestBase
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
        HomePage homePage=new HomePage(driver);
        HotSaucePage hotSausPage=homePage.clickOnHotsauce();
        boolean hotSaucePageLable=hotSausPage.verifyHotSaucePageLable();
        Assert.assertTrue(hotSaucePageLable);
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().equals("Hot Sauces - Test Site"));
    }

    @Test(priority = 2)
    public void selectHotSauceTest() throws InterruptedException
    {
        List<String> list=new ArrayList<>();
        HomePage homePage=new HomePage(driver);
        HotSaucePage hotSaucePage=new HotSaucePage(driver);

        Thread.sleep(1000);
        hotSaucePage.setSelectPrice();
        hotSaucePage.setSortBy();
        hotSaucePage.setManufacturer();
        hotSaucePage.setHeatRange();
        hotSaucePage.setViewHotSuace();
        Thread.sleep(500);
        String element=driver.findElement(By.xpath("//div[@class='col-sm-10']//button[@class='btn']")).getText();
        System.out.println("Element Text is : "+element);
        if(element.equals("OUT OF STOCK"))
        {
            driver.navigate().back();
        }
        else
        {
            hotSaucePage.verifyToShowHotSauses();

            List<WebElement> productName = driver.findElements(By.xpath("//div[@class='row']/child::div[@class='col-sm-7']"));
            for (WebElement webElement : productName)
            {
                System.out.println(webElement.getText());
                list.add(webElement.getText());
            }
            System.out.println(list);
            //Assert.assertEquals(productName,"DAY OF THE DEAD CHIPOTLE HOT SAUCE","Product name is incorrect");

            ShippingPage shippingPage = new ShippingPage(driver);
            homePage = shippingPage.VerifyShippingPage(property.getProperty("fullName"),
                    property.getProperty("address1"), property.getProperty("address2"),
                    property.getProperty("city"), property.getProperty("state"),
                    property.getProperty("postal"), property.getProperty("mobileno"));
            Assert.assertTrue(homePage.verifyUserName());
        }
    }
}
