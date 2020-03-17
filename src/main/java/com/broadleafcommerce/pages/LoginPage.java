package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase
{
    //PageFactory-Object Repository
    @FindBy(id="username")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement clickLogin;


    //Initializing the page Objects
    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    //Actions
    public String validateLoginPageTitle()
    {
        return driver.getTitle();
    }


    public HomePage login(String userName,String password1) throws InterruptedException
    {
        email.sendKeys(userName);
        Thread.sleep(1000);
        password.sendKeys(password1);
        Thread.sleep(1000);
        clickLogin.click();
        Thread.sleep(1000);
        return new HomePage(driver);
    }
}
