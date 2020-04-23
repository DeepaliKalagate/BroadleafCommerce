package com.thoughtworks.script;
import com.thoughtworks.base.Listener;
import com.thoughtworks.base.TestBase;
import com.thoughtworks.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class LoginTest extends TestBase
{
    @Test(priority = 1)
    public void validateLoginIsSuccessful()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(driver.findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");
    }

    @Test(priority = 2)
    public void validateLoginFailed()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("deepali.kalagate91@gmail.com","Pass@123");
        boolean isLoginFailed = driver.findElement(By.xpath("//*[@id=\"login\"]/form/p")).isDisplayed();
        Assert.assertEquals(isLoginFailed,true);
    }
}
