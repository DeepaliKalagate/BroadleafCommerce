package com.broadleafcommerce.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement login;

    @FindBy(id="username")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement clickLogin;

    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void login(String username,String password1)
    {
        email.sendKeys(username);
        password.sendKeys(password1);
        clickLogin.click();
    }
}
