package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardPage extends TestBase
{
    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Gift Cards')]")
    private WebElement giftCard;

    public GiftCardPage()
    {
        PageFactory.initElements(driver,this);
    }
    public void setGiftCard()
    {
        giftCard.click();
    }
}
