package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardPage extends BaseClass
{
    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Gift Cards')]")
    private WebElement giftCard;

    public GiftCardPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void setGiftCard()
    {
        giftCard.click();
    }
}
