package com.thoughtworks.script;
import com.thoughtworks.base.Listener;
import com.thoughtworks.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest
{
    @Test(priority = 1)
    public void validateLoginIsSuccessful()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(property.getProperty("email"),property.getProperty("password"));
        Assert.assertEquals(getDriver().findElement(By.className("material-icons")).isDisplayed(),true,"Verify Login is Successful");
    }

    @Test(priority = 2)
    public void validateLoginFailed()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("deepali.kalagate91@gmail.com","Pass@123");
        boolean isLoginFailed = getDriver().findElement(By.xpath("//*[@id=\"login\"]/form/p")).isDisplayed();
        Assert.assertEquals(isLoginFailed,true);
    }
}
