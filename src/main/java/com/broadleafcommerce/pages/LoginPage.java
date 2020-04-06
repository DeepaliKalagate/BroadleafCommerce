package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase
{
    //PageFactory-Object Repository
    @FindBy(xpath = "//img[contains(@class,'brand-logo')]")
    private WebElement logoImage;

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
    public boolean verifyLogoImage()
    {
        return logoImage.isDisplayed();
    }

    public void setEmail(String userName)
    {
        email.sendKeys(userName);
    }

    public void setPassword(String password1)
    {
        password.sendKeys(password1);
    }

    public HomePage clickOnLogin()
    {
        clickLogin.click();
        return new HomePage(driver);
    }
}
