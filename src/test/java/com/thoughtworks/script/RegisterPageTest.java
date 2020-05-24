package com.thoughtworks.script;
import com.thoughtworks.base.Listener;
import com.thoughtworks.pages.RegisterPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest
{
    @Test()
    public void validateRegisterIsSuccessful()
    {
        RegisterPage registerPage=new RegisterPage(getDriver());
        registerPage.register(property.getProperty("email"),property.getProperty("name"),
                property.getProperty("lastName"),property.getProperty("password"),
                property.getProperty("confirmPassword"));
        Assert.assertEquals(getDriver().findElement(By.className("material-icons")).isDisplayed(),true,"Verify Register is Successful");
    }
}
