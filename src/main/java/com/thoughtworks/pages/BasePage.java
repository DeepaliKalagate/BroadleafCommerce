package com.thoughtworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage
{
    protected WebDriver driver =null;
    protected WebDriverWait wait =null;

    public BasePage(WebDriver driver)
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
