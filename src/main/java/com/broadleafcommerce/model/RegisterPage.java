package com.broadleafcommerce.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage
{
    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement login;

    @FindBy(id="customer.emailAddress")
    private WebElement email;

    @FindBy(id="customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;


    @FindBy(xpath = "//div[@class='label-floating form-group error-group is-empty']//input[@id='password']")
    private WebElement password;

    @FindBy(id="passwordConfirm")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[contains(text(),'Register')]")
    private WebElement clickRegister;

    public RegisterPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setLogin()
    {
        login.click();
    }

    public void setEmail(String username)
    {
        email.sendKeys(username);
    }

    public void setFirstName(String firstname)
    {
        firstName.sendKeys(firstname);
    }

    public void setLastName(String lastname)
    {
        lastName.sendKeys(lastname);
    }

    public void setPassword(String password1)
    {
        password.sendKeys(password1);
    }

    public void setConfirmPassword(String confirmPass)
    {
        confirmPassword.sendKeys(confirmPass);
    }

    public void setClickRegister()
    {
        clickRegister.click();
    }
}
