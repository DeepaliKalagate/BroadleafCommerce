package com.thoughtworks.script;
import com.thoughtworks.base.Listener;
import com.thoughtworks.base.TestBase;
import com.thoughtworks.pages.RegisterPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class RegisterPageTest extends TestBase
{
    @Test()
    public void validateRegisterIsSuccessful()
    {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.register(property.getProperty("email"),property.getProperty("name"),
                property.getProperty("lastName"),property.getProperty("password"),
                property.getProperty("confirmPassword"));
        Assert.assertEquals(driver.findElement(By.className("material-icons")).isDisplayed(),true,"Verify Register is Successful");
    }
}
