package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends TestBase
{
    //Page Factory-Object Repository
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

    @FindBy(xpath = "//img[contains(@class,'brand-logo')]")
    private WebElement broadleafLogo;

    //Initializing the page Objects
    public RegisterPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    //Actions
    public String validateRegisterPageTitle()
    {
        return driver.getTitle();
    }

    public boolean validateBroadleafLogoImage()
    {
        return broadleafLogo.isDisplayed();
    }

    public HomePage verifyRegisterPage(String userName,String fName,String lName,String password1,String confirmPass)
    {
        email.sendKeys(userName);
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        password.sendKeys(password1);
        confirmPassword.sendKeys(confirmPass);
        clickRegister.click();
        return new HomePage(driver);
    }
}
