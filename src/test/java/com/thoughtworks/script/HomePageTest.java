package com.thoughtworks.script;
import com.thoughtworks.base.Listener;
import com.thoughtworks.base.TestBase;
import com.thoughtworks.pages.HomePage;
import com.thoughtworks.pages.HotSaucePage;
import com.thoughtworks.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class HomePageTest extends TestBase
{
    @Test()
    public void verifyHotSauceLinkTest()
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(driver.findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");

        HomePage homePage=new HomePage(driver);
        boolean userName=homePage.verifyUserName();
        Assert.assertTrue(userName);
        HotSaucePage hotSaucePage =new HotSaucePage(driver);
        hotSaucePage = homePage.clickOnHotsauce();
        Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='section-title']//span[contains(text(),'Hot Sauces')]"))
                            .isDisplayed(), true,"Verify HotSauce Page is Open Successful");
    }
}
