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

public class ProductRemoveFromCartTest extends TestBase
{
    @BeforeMethod
    public void setLoginPage()
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.setEmail("deepali.kalagate@thoughtworks.com");
        loginPage.setPassword("Mysweetfamily@333");
        loginPage.clickOnLogin();
        ClearancePage clearancePage=new ClearancePage(driver);
        HomePage homePage=new HomePage(driver);
        clearancePage=homePage.clickOnClearance();
    }

    @Test
    public void productRemoveFromCartTest() throws InterruptedException
    {
        List<String> list=new ArrayList<>();
        ProductRemoveFromCartPage removeFromCartPage=new ProductRemoveFromCartPage(driver);
        removeFromCartPage.setSelectItem();
        Thread.sleep(500);
        String element=driver.findElement(By.xpath("//div[@class='col-sm-10']//button[@class='btn']")).getText();
        System.out.println("Element Text is : "+element);
        if(element.equals("OUT OF STOCK"))
        {
            driver.navigate().back();
        }
        else
        {
            removeFromCartPage.setAddToCart();
            removeFromCartPage.setViewInCart();
            List<WebElement> productName = driver.findElements(By.xpath("//div[@class='col-sm-7']"));
            for (WebElement webElement : productName)
            {
                System.out.println(webElement.getText());
                list.add(webElement.getText());
            }
            System.out.println(list);
            Assert.assertEquals(list.contains("BLAZIN' SADDLE XXX HOT HABANERO PEPPER SAUCE"),"Product name is incorrect");
            for (int i=0;i<list.size();i++)
            {
                removeFromCartPage.setRemoveitem();
                Thread.sleep(500);
            }
            removeFromCartPage.setClickOnDropdown();
            removeFromCartPage.setClickOnLogout();
        }
    }
}
