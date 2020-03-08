package com.broadleafcommerce.model;

import com.broadleafcommerce.base.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCard extends Browser
{
    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Gift Cards')]")
    private WebElement giftCard;

    public GiftCard(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void setGiftCard()
    {
        giftCard.click();
    }
}
