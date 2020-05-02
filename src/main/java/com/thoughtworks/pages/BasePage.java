package com.thoughtworks.pages;
import com.thoughtworks.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest
{
    public WebDriver driver;
    public WebDriverWait wait =null;

    public BasePage( WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(this.driver,10);
    }

    public boolean isDisplayed(WebElement webElement)
    {
        return webElement.isDisplayed();
    }
}
