package com.thoughtworks.script;
import com.thoughtworks.base.Listener;
import com.thoughtworks.base.BaseTest;
import com.thoughtworks.pages.HomePage;
import com.thoughtworks.pages.LoginPage;
import com.thoughtworks.pages.MerchandisePage;
import com.thoughtworks.pages.ProductListingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

@Listeners(Listener.class)
public class MarchandisePageTest extends BaseTest
{
    @Test()
    public void verifyMerchandiseTest() throws InterruptedException
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(driver.findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");

        MerchandisePage merchandisePage=new MerchandisePage(driver);
        HomePage homePage=new HomePage(driver);
        merchandisePage=homePage.clickOnMerchandise();
        Assert.assertTrue(driver.getTitle().equals("Merchandise - Test Site"));

        homePage.clickOnWomensMerchandise();
        ProductListingPage productListingPage=new ProductListingPage(driver);
        productListingPage.selectSortBy();

        merchandisePage.selectFilterByPrice();
        merchandisePage.selectFilterByColor();
        merchandisePage.selectProductImage();
        merchandisePage.selectSilverColor();
        merchandisePage.selectShirtSize("M");
        merchandisePage.productAddToWishlist();
        Thread.sleep(500);
        merchandisePage.clickOnDropdown();
        merchandisePage.clickOnProfile();
        merchandisePage.clickOnManageWishlist();

        //Getting list of Items from Cart
        List<String> addedProduct =new ArrayList<>();
        driver.findElements(By.xpath("//*[@id=\"productRow382\"]/div[2]/div[1]/div[1]/div/a")).forEach(webElement1 -> {addedProduct.add(webElement1.getText());});
        Assert.assertTrue(addedProduct.contains("HAWT LIKE A HABANERO SHIRT (WOMEN'S) SILVER (MEDIUM)"),"Product name is incorrect");
    }
}
