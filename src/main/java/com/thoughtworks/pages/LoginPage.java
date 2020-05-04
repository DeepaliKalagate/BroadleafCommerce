package com.thoughtworks.pages;
import com.thoughtworks.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
    BaseTest baseTest;

    //PageFactory-Object Repository
    @FindBy(id="username")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement btnLogin;

    //Initializing the page Objects
    public LoginPage(WebDriver driver)
    {
        super(driver);
        baseTest=new BaseTest();
    }

    //Actions
    public HomePage login(String userName,String password1)
    {
        email.sendKeys(userName);
        password.sendKeys(password1);
        btnLogin.click();
        return new HomePage(driver);
    }
}
