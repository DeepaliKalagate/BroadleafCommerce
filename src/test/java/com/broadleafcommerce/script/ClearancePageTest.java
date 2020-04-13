package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Listener;
import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.ClearancePage;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.LoginPage;
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
    public void verifyClearancePageTextAndTitle()
    {
        ClearancePage clearancePage=new ClearancePage(driver);
        boolean clearancePageText=clearancePage.verifyClearancePageText();
        Assert.assertTrue(clearancePageText);
        Assert.assertTrue(driver.getTitle().equals("Clearance - Test Site"));
    }

    @Test
    public void verifyClearancePageTest()
    {
        List<String> list=new ArrayList<>();
        ClearancePage clearancePage=new ClearancePage(driver);
        clearancePage.setSearchSauce("Blazin");
        clearancePage.setViewHotSuace();
        clearancePage.setClearanceItem();
        clearancePage.setAddToCart();
        clearancePage.verifyClearancePage();

        List<WebElement> productName =driver.findElements(By.xpath("//div[@class='row']/child::div[@class='col-sm-7']"));
        for (WebElement webElement:productName)
        {
            System.out.println(webElement.getText());
            list.add(webElement.getText());
        }
        System.out.println(list);
       Assert.assertTrue(list.contains("BLAZIN' SADDLE XXX HOT HABANERO PEPPER SAUCE"),"Product name is incorrect");
    }
}
