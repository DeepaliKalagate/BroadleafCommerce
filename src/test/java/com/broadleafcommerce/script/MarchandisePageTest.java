package com.broadleafcommerce.script;

import com.broadleafcommerce.base.Listener;
import com.broadleafcommerce.base.TestBase;
import com.broadleafcommerce.pages.HomePage;
import com.broadleafcommerce.pages.LoginPage;
import com.broadleafcommerce.pages.MerchandisePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

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
        merchandisePage.setAddToWishlist();
        Thread.sleep(500);
        merchandisePage.setClickOnDropdown();
        merchandisePage.setClickOnProfile();
        merchandisePage.setClickOnManageWishlist();

        //Getting list of Items from Cart
        List<WebElement> productName =driver.findElements(By.xpath("//*[@id=\"productRow382\"]/div[2]/div[1]/div[1]/div/a"));
        for (WebElement webElement:productName)
        {
            System.out.println(webElement.getText());
            list.add(webElement.getText());
        }
        System.out.println(list);
      Assert.assertTrue(list.contains("HAWT LIKE A HABANERO SHIRT (WOMEN'S) SILVER (MEDIUM)"),"Product name is incorrect");
    }
}
