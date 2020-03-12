package com.broadleafcommerce.pages;


import com.broadleafcommerce.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass
{
    @FindBy(css = "body.locale-en_US:nth-child(2) nav.navbar.navbar-default.navbar-top.navbar-fixed-top:nth-child(5) div.container-fluid div.left-nav.hidden-xs.collapse.main-menu-wrapper ul.nav.navbar-nav.main-menu li:nth-child(1) a:nth-child(1) > span:nth-child(1)")
    private WebElement home;

    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

}
