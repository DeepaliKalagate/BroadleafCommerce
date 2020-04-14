package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotSauce extends TestBase
{
    @FindBy(className = "section-title")
    private WebElement hotsauceLable;

    @FindBy(xpath = "//div[@id='right_column']//div[@data-id='1']")
    private WebElement viewHotSauce;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement viewInCart;

    public HotSauce(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyHotSaucePageLable()
    {
        return hotsauceLable.isDisplayed();
    }

    public void setViewHotSauce()
    {
        viewHotSauce.click();
    }

    public void setAddToCart()
    {
        addToCart.click();
    }

    public ShippingPage verifyToShowHotSauses()
    {
        viewInCart.click();
        return new ShippingPage(driver);
    }
}
