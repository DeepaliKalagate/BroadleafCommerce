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
public class MarchandiseRemoveFromCartPageTest extends TestBase
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

    @Test(priority = 1)
    public void verifyMerchandisePageTextAndTitle() throws InterruptedException
    {
        MerchandiseRemoveFromCartPage removeFromCartPage=new MerchandiseRemoveFromCartPage(driver);
        boolean merchandisePageText=removeFromCartPage.verifyMarchandisePageText();
        Assert.assertTrue(merchandisePageText);
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().equals("Merchandise - Test Site"));
    }

    @Test(priority = 2)
    public void verifyMerchandiseTest() throws InterruptedException
    {
        List<String> list=new ArrayList<>();
        HomePage homePage=new HomePage(driver);
        homePage.clickOnWomensMerchandise();
        MerchandiseRemoveFromCartPage removeFromCartPage=new MerchandiseRemoveFromCartPage(driver);

        removeFromCartPage.setSortBy();
        removeFromCartPage.setPrice();
        removeFromCartPage.setFilter();
        removeFromCartPage.setSilver();
        removeFromCartPage.setSortByPrice();
        removeFromCartPage.setSilverPrice();
        removeFromCartPage.setShirtImage();
        removeFromCartPage.setSelectSilver();
        removeFromCartPage.setShirtSize("M");
        removeFromCartPage.setAddToCart();
        removeFromCartPage.setViewInCart();

        List<WebElement> productName =driver.findElements(By.xpath("//div[@class='col-sm-7']"));
        for (WebElement webElement:productName)
        {
            System.out.println(webElement.getText());
            list.add(webElement.getText());
        }
        System.out.println(list);
        Assert.assertTrue(productName.contains("HAWT LIKE A HABANERO SHIRT (WOMEN'S) SILVER (MEDIUM)"),"Product name is incorrect");


        homePage=removeFromCartPage.verifyMerchandisePage();
        Assert.assertTrue(homePage.verifyUserName());
        Thread.sleep(2000);
    }
}
