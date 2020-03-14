package com.broadleafcommerce.pages;

import com.broadleafcommerce.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardPage extends TestBase
{
    @FindBy(xpath = "//h2[@class='section-title']")
    private WebElement giftCardPageText;

    @FindBy(xpath = "//div[@id='left-nav']//span[contains(text(),'Gift Cards')]")
    private WebElement giftCard;

    @FindBy(xpath = "//body[@class='locale-en_US index-page']/div[@class='main']/div[@class='container']/div[@id='category']/div[@id='category-search-content']/div[@id='right_column']/div[@id='products']/div[1]/div[1]/a[1]/div[1]")
    private WebElement selectGiftCard;

    @FindBy(xpath = "//textarea[@name='itemAttributes[null]']")
    private WebElement personalMessage;

    @FindBy(xpath = "//body/div/div/div/div/div/div/div[3]/div[1]/input[1]")
    private WebElement sender;

    @FindBy(xpath = "//div//div//div//div//div//div//div[4]//input[1]")
    private WebElement email;

    @FindBy(xpath = "//div[5]//div[1]//input[1]")
    private WebElement name;

    @FindBy(xpath = "//button[@class='btn btn-primary js-addToCart']")
    private WebElement clickAddToCart;

    public GiftCardPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String verifyGiftCardPageTitle()
    {
        return driver.getTitle();
    }

    public void setGiftCard()
    {
        giftCard.click();
    }

    public ShippingPage setGiftCard(String message,String senderName,String recipientEmail,String recipientName)
    {
        giftCard.click();
        selectGiftCard.click();
        personalMessage.sendKeys(message);
        sender.sendKeys(senderName);
        email.sendKeys(recipientEmail);
        name.sendKeys(recipientName);
        clickAddToCart.click();
        return new ShippingPage();
    }
}
